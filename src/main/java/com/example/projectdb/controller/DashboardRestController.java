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
        Double augSum = uorepo.augSum();

        HashMap<String, Object> map = new HashMap<>();
        map.put("count_hawkerlisting", hawkerListingCount);
        map.put("count_courierlisting", courierListingCount);
        map.put("count_orders", ordersCount);
        map.put("count_orderSum", orderSum);
        map.put("count_augSum", augSum);

		
		 /* //Area Chart List<MorisArea> morisAreas = new ArrayList<>();
		  morisAreas.add(new MorisArea("2011 Q1", 2666, 2666 )); morisAreas.add(new
		  MorisArea("2011 Q2", 2778, 2294 )); morisAreas.add(new MorisArea("2011 Q3",
		  4912, 1969 )); morisAreas.add(new MorisArea("2011 Q4", 3767, 3597 ));
		  
		  morisAreas.add(new MorisArea("2012 Q1", 6810, 1914 )); morisAreas.add(new
		  MorisArea("2012 Q2", 5670, 4293 )); morisAreas.add(new MorisArea("2012 Q3",
		  4820, 3795 )); morisAreas.add(new MorisArea("2012 Q4", 15073, 5967 ));
		  
		  morisAreas.add(new MorisArea("2013 Q1", 10687, 4460 )); morisAreas.add(new
		  MorisArea("2013 Q2", 8432, 5713 ));
		  
		  map.put("areachart", morisAreas);*/
		  
		  //Line Chart 
          List<MorisLine> morisLine = new ArrayList<>(); 
          morisLine.add(new MorisLine("January", augSum)); 
          morisLine.add(new MorisLine("February", 2778 ));
		  morisLine.add(new MorisLine("March", 4912 )); 
		  morisLine.add(new MorisLine("April", 3767 )); 
		  morisLine.add(new MorisLine("May", 6810 ));
		  morisLine.add(new MorisLine("June", 5670 )); 
		  morisLine.add(new MorisLine("July", 4820 )); 
		  morisLine.add(new MorisLine("August", 15073)); 
		  morisLine.add(new MorisLine("September", 10687 )); 
		  morisLine.add(new MorisLine("October", 8432 ));
		  morisLine.add(new MorisLine("November", 15073)); 
		  morisLine.add(new MorisLine("December", 10687 )); 
		  
		  map.put("line-chart", morisLine);
		  
	/*	  //Donut Chart List<MorisDonut> morisDonuts = new ArrayList<>();
		  morisDonuts.add(new MorisDonut("Download Sales", 12 )); morisDonuts.add(new
		  MorisDonut("In-Store Sales", 30 )); morisDonuts.add(new
		  MorisDonut("Mail-Order Sales", 20 ));
		  
		  map.put("donutchart", morisDonuts);*/
		 

        return map;
        
        
    }

}
//
//@JsonAutoDetect
//class MorisArea implements Serializable {
//    private static final long serialVersionUID = 4992047206653043217L;
//
//    public MorisArea(String y, Number item1, Number item2){
//        this.y=y;
//        this.item1=item1;
//        this.item2=item2;
//    }
//
//    private String y;
//    public String getY() {
//        return y;
//    }
//    public void set(String y){
//        this.y=y;
//    }
//
//    private Number item1;
//    public void setItem1(Number item1) {
//        this.item1 = item1;
//    }
//    public Number getItem1(){
//        return this.item1;
//    }
//
//    private Number item2;
//    public void setItem2(Number item2) {
//        this.item2 = item2;
//    }
//    public Number getItem2(){
//        return this.item2;
//    }
//}
//
@JsonAutoDetect
class MorisLine implements Serializable {
    private static final long serialVersionUID = 4992047206653043217L;

    public MorisLine(String y, Number item1) {
        this.y = y;
        this.item1 = item1;
    }

    private String y;

    public String getY() {
        return y;
    }

    public void set(String y) {
        this.y = y;
    }

    private Number item1;

    public void setItem1(Number item1) {
        this.item1 = item1;
    }
    public Number getItem1() {
        return this.item1;
    }
}
//
//
//
//@JsonAutoDetect
//class MorisDonut implements Serializable {
//    private static final long serialVersionUID = 4992047206653043217L;
//
//    public MorisDonut(String label, Number value) {
//        this.label = label;
//        this.value = value;
//    }
//
//    private String label;
//    public String getLabel() {
//        return label;
//    }
//
//    public void setLabel(String label) {
//        this.label = label;
//    }
//
//    private Number value;
//    public void setValue(Number value) {
//        this.value = value;
//    }
//    public Number getValue(){
//        return this.value;
//    }
//}