package com.example.projectdb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdb.model.User;
import com.example.projectdb.service.CourierListingService;
import com.example.projectdb.service.UserOrderService;
import com.example.projectdb.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService uservice;
    
    @Autowired
    CourierListingService clservice;
    
    @Autowired 
    UserOrderService uoservice;
    
    @PostMapping("/users/register")
    public ResponseEntity<String> registerUser(@RequestBody User newUser) {
        List<User> users = uservice.findAll();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
            }
        }
        uservice.save(newUser);
        return new ResponseEntity<String>("Success", HttpStatus.CREATED);
    }
    
    @PostMapping("/users/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        List<User> users = uservice.findAll();
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
		
		
		ArrayList<ArrayList<String>> cl = (ArrayList<ArrayList<String>>)clservice.findCourierListing();	
		
		return new ResponseEntity<ArrayList<ArrayList<String>>>(cl,HttpStatus.OK);
	}
    
    @RequestMapping("/users/courierListing/{id}")	
	public ResponseEntity<ArrayList<ArrayList<String>>> viewFoodItem
	(@PathVariable("id") Long CourierListingId,@RequestParam Long hawkerId){
	
		ArrayList<ArrayList<String>> data = (ArrayList<ArrayList<String>>)clservice
				.findFoodItemByCourierListingId(CourierListingId,hawkerId);
		
		return new ResponseEntity<ArrayList<ArrayList<String>>>(data,HttpStatus.OK);
	}
    
    @RequestMapping("/users/userorder")
   	public ResponseEntity<ArrayList<ArrayList<String>>> viewAllUserOrder(){
   		ArrayList<ArrayList<String>> userorders = (ArrayList<ArrayList<String>>)uoservice.findUserOrder();	
   		return new ResponseEntity<ArrayList<ArrayList<String>>>(userorders,HttpStatus.OK);
   	}
}