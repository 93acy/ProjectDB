//package com.example.projectdb.controller;
//
//import com.example.projectdb.model.User;
//import com.example.projectdb.repo.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class UserController {
//    @Autowired
//    UserRepository userRepository;
//    @PostMapping("/users/register")
//    public ResponseEntity<String> registerUser(@RequestBody User newUser) {
//        List<User> users = userRepository.findAll();
//        System.out.println("New user: " + newUser.toString());
//        for (User user : users) {
//            if (user.equals(newUser)) {
//                System.out.println("User Already exists!");
//                return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
//            }
//        }
//        userRepository.save(newUser);
//        return new ResponseEntity<String>("Success", HttpStatus.CREATED);
//    }
//    @PostMapping("/users/login")
//    public ResponseEntity<String> loginUser(@RequestBody User user) {
//        List<User> users = userRepository.findAll();
//        for (User other : users) {
//            if (other.equals(user)) {
////                other.setLoggedIn(true);
////                userRepository.save(other);
//                return new ResponseEntity<String>("Success", HttpStatus.CREATED);
//            }
//        }
//        return new ResponseEntity<String>("Failure", HttpStatus.FORBIDDEN);
//    }
//}