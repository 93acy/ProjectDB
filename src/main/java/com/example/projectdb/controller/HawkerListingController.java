package com.example.projectdb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdb.model.HawkerListing;
import com.example.projectdb.service.HawkerListingService;

@RestController
@RequestMapping("/hawkerlisting")
public class HawkerListingController{

    @Autowired
    private HawkerListingService hlservice;

    @GetMapping("/All")
    public ResponseEntity<ArrayList<ArrayList<String>>> viewAllListings(){
    	ArrayList<ArrayList<String>> hawkerlist= hlservice.findHawker();
        return new ResponseEntity<ArrayList<ArrayList<String>>>(hawkerlist, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addHawkerListing(@RequestBody HawkerListing hawkerlisting){
        hlservice.addHawkerListing(hawkerlisting);
        return new ResponseEntity<String>("Success", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateHawkerListing(@RequestBody HawkerListing hawkerlisting){
        hlservice.updateHawkerListing(hawkerlisting);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHawkerListing(@PathVariable("id") Long id){
        hlservice.deleteHawkerListing(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }








}
