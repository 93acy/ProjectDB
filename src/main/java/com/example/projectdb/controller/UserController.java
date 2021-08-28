package com.example.projectdb.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.projectdb.repo.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdb.model.User;
import com.example.projectdb.repo.CourierListingRepository;
import com.example.projectdb.repo.UserRepository;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    CourierListingRepository clrepo;

    @Autowired
    UserOrderRepository userOrderRepository;
    
    @PostMapping("/users/register")
    public ResponseEntity<String> registerUser(@RequestBody User newUser) {
        List<User> users = userRepository.findAll();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
            }
        }
        userRepository.save(newUser);
        return new ResponseEntity<String>("Success", HttpStatus.CREATED);
    }
    
    @PostMapping("/users/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
//                other.setLoggedIn(true);
//                userRepository.save(other);
                return new ResponseEntity<String>("Success", HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<String>("Failure", HttpStatus.FORBIDDEN);
    }
    
    @RequestMapping("/users/courierListing")
	public ResponseEntity<ArrayList<ArrayList<String>>> selectCourierListing(){
		
		
		ArrayList<ArrayList<String>> cl = (ArrayList<ArrayList<String>>)clrepo.findCourierListing();	
		
		return new ResponseEntity<ArrayList<ArrayList<String>>>(cl,HttpStatus.OK);
	}
    
    @RequestMapping("/users/courierListing/{id}")	
	public ResponseEntity<ArrayList<ArrayList<String>>> viewFoodItem
	(@PathVariable("id") Long CourierListingId,@RequestParam Long hawkerId){
	
		ArrayList<ArrayList<String>> data = (ArrayList<ArrayList<String>>)clrepo
				.findFoodItemByCourierListingId(CourierListingId,hawkerId);
		
		return new ResponseEntity<ArrayList<ArrayList<String>>>(data,HttpStatus.OK);
	}

    @RequestMapping("/users/courierListingPickup/{id}")
    public ResponseEntity<ArrayList<ArrayList<String>>> viewPickupDetails(@PathVariable("id") Long userOrderId)
    {

        ArrayList<ArrayList<String>>  data = userOrderRepository
                .findCourierPickupDetailsByCourierListingId(userOrderId);


        return new ResponseEntity<ArrayList<ArrayList<String>>>(data,HttpStatus.OK);
    }

    @RequestMapping("users/orders/foodItems/{id}")
    public ResponseEntity<ArrayList<ArrayList<String>>> viewOrderFoodItem(@PathVariable("id") Long userOrderId){

        ArrayList<ArrayList<String>> food = (ArrayList<ArrayList<String>>)userOrderRepository
                .findUserOrderFoodItemByUserOrderId(userOrderId);

        return new ResponseEntity<ArrayList<ArrayList<String>>>(food,HttpStatus.OK);
    }

    @RequestMapping("users/orders/orderStatus/update")
    public ResponseEntity<String> updateUserOrderStatus(@PathVariable("id") Long userOrderId,@RequestParam String status){
        userOrderRepository.updateUserOrderStatus(userOrderId,status);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
    }


}