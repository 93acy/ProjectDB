package com.example.projectdb.service;

import java.util.ArrayList;
import java.util.List;

public interface UserOrderService {

	public ArrayList<ArrayList<String>> findUserOrder();
	
	public List<List<String>> findByCourierListingId(Long id);
	
	public List<List<String>> findUserDetailsByCourierListingId(Long id);

}
