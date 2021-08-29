package com.example.projectdb.controller;

import com.example.projectdb.repo.CourierListingRepository;
import com.example.projectdb.repo.HawkerListingRepository;
import com.example.projectdb.repo.UserOrderRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardRestController {
	

    @Autowired
    private HawkerListingRepository hrepo;
    
    @Autowired
    private CourierListingRepository crepo;
    
    @Autowired
    private UserOrderRepository uorepo;

    @GetMapping("/statistics")
    public HashMap<String, Object> getDashboardStatistics(){
        long hawkerListingCount = hrepo.count();
        long courierListingCount = crepo.count();
        long ordersCount = uorepo.count();
        Double orderSum = uorepo.orderSum();
        Double janSum = uorepo.janSum();
        Double febSum = uorepo.febSum();
        Double marSum = uorepo.marSum();
        Double aprSum = uorepo.aprSum();
        Double maySum = uorepo.maySum();
        Double junSum = uorepo.junSum();
        Double julSum = uorepo.julSum();
        Double augSum = uorepo.augSum();
        Double sepSum = uorepo.sepSum();
        Double octSum = uorepo.octSum();
        Double novSum = uorepo.novSum();
        Double decSum = uorepo.decSum();
        long janOrder = uorepo.janOrder();
        long febOrder = uorepo.febOrder();
        long marOrder = uorepo.marOrder();
        long aprOrder = uorepo.aprOrder();
        long mayOrder = uorepo.mayOrder();
        long junOrder = uorepo.junOrder();
        long julOrder = uorepo.julOrder();
        long augOrder = uorepo.augOrder();
        long sepOrder = uorepo.sepOrder();
        long octOrder = uorepo.octOrder();
        long novOrder = uorepo.novOrder();
        long decOrder = uorepo.decOrder();


        HashMap<String, Object> map = new HashMap<>();
        map.put("count_hawkerlisting", hawkerListingCount);
        map.put("count_courierlisting", courierListingCount);
        map.put("count_orders", ordersCount);
        map.put("count_orderSum", orderSum);
        map.put("count_janSum", janSum);
        map.put("count_febSum", febSum);
        map.put("count_marSum", marSum);
        map.put("count_aprSum", aprSum);
        map.put("count_maySum", maySum);
        map.put("count_junSum", junSum);
        map.put("count_julSum", julSum);
        map.put("count_augSum", augSum);
        map.put("count_sepSum", sepSum);
        map.put("count_octSum", octSum);
        map.put("count_novSum", novSum);
        map.put("count_decSum", decSum);
        map.put("janOrder", janOrder);
        map.put("febOrder", febOrder);
        map.put("marOrder", marOrder);
        map.put("aprOrder", aprOrder);
        map.put("mayOrder", mayOrder);
        map.put("junOrder", junOrder);
        map.put("julOrder", julOrder);
        map.put("augOrder", augOrder);
        map.put("sepOrder", sepOrder);
        map.put("octOrder", octOrder);
        map.put("novOrder", novOrder);
        map.put("decOrder", decOrder);
        
        return map;
        
        
    }

}
