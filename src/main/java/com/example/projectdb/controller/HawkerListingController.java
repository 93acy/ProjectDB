package com.example.projectdb.controller;

import com.example.projectdb.model.HawkerListing;
import com.example.projectdb.service.HawkerListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hawkerlisting")
public class HawkerListingController{

    @Autowired
    private HawkerListingService hlservice;

    @GetMapping("/All")
    public ResponseEntity<List<HawkerListing>> viewAllListings(){
        List<HawkerListing> hawkerlist= hlservice.findAll();
        return new ResponseEntity<>(hawkerlist, HttpStatus.OK);
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
