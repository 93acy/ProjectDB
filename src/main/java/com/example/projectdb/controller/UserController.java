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
import com.example.projectdb.model.UserOrder;
import com.example.projectdb.model.UserOrderDetail;
import com.example.projectdb.repo.UserRepository;
import com.example.projectdb.service.CourierListingService;
import com.example.projectdb.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    CourierListingService clService;
    
    @Autowired
    UserService uService;

    @PostMapping("/register")
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
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
//                other.setLoggedIn(true);
                userRepository.save(other);
                return new ResponseEntity<String>("Success", HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<String>("Failure", HttpStatus.FORBIDDEN);
    }
    
    
    @RequestMapping("/users/courierListing")
	public ResponseEntity<ArrayList<ArrayList<String>>> selectCourierListing(){
		
		
		ArrayList<ArrayList<String>> cl = (ArrayList<ArrayList<String>>)clService.findCourierListing();	
		
		return new ResponseEntity<ArrayList<ArrayList<String>>>(cl,HttpStatus.OK);
	}
    
    @RequestMapping("/users/courierListing/{id}")	
	public ResponseEntity<ArrayList<ArrayList<String>>> viewFoodItem
	(@PathVariable("id") Long CourierListingId,@RequestParam Long hawkerId){
	
		ArrayList<ArrayList<String>> data = (ArrayList<ArrayList<String>>)clService
				.findFoodItemByCourierListingId(CourierListingId,hawkerId);
		
		return new ResponseEntity<ArrayList<ArrayList<String>>>(data,HttpStatus.OK);
	}
    
    
    @RequestMapping("/user/createOrder")
    public ResponseEntity<String> createUserOrder (@RequestBody UserOrder userOrder,
    		@RequestParam Long courierListngId){
    	
    	uService.saveUserOrder(userOrder);
    	Long userOrderId = userOrder.getId();
    	
    	uService.updateCourierListingId(userOrderId, courierListngId);
    	
    	return new ResponseEntity<String>(userOrderId.toString(),HttpStatus.OK);

    }
    
    @RequestMapping("/user/createOrderDetail")
    public ResponseEntity<String> createUserOrderDetail (@RequestBody List<UserOrderDetail> userOrderDetail,
    		@RequestParam Long userOrderId,@RequestParam List<Long> courierFoodItemDetail){
    	
    	for(int i =0;i<userOrderDetail.size();i++) {
    		
    		uService.saveUserOrderDetail(userOrderDetail.get(i));
    		
    		uService.updateOrderIdAndCFID(userOrderId,courierFoodItemDetail.get(i) , userOrderDetail.get(i).getId());
    	}
    	
    	return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
    };
    
}