package com.example.projectdb.controller;

import com.example.projectdb.config.JwtTokenUtil;
import com.example.projectdb.model.HawkerListing;
import com.example.projectdb.repo.HawkerListingRepository;
import com.example.projectdb.service.HawkerListingService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hawkerlisting")
public class HawkerListingController{

    @Autowired
    HawkerListingRepository hrepo;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    HttpServletRequest request;

    @Autowired
    private HawkerListingService hlservice;

    @GetMapping("/All")
    public ResponseEntity<ArrayList<ArrayList<String>>> viewAllListings(){
//        List<HawkerListing> hawkerlist= hlservice.findAll();
        ArrayList<ArrayList<String>> hl = (ArrayList<ArrayList<String>>)hrepo.findHawker();
//        return new ResponseEntity<>(hawkerlist, HttpStatus.OK);



        return new ResponseEntity<ArrayList<ArrayList<String>>>(hl,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addHawkerListing(@RequestBody HawkerListing hawkerlisting){
        String username = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
        //findIdbyUsername
        if (!hrepo.hawkerNameExist(hawkerlisting.getName())){
        hlservice.addHawkerListing(hawkerlisting);
        return new ResponseEntity<String>("Success", HttpStatus.CREATED);}
        else{ return new ResponseEntity<String>("Not Successful", HttpStatus.BAD_REQUEST);}
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
