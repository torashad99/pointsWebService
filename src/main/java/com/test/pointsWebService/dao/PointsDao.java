package com.test.pointsWebService.dao;

import java.util.List;
import java.util.HashMap;

import com.test.pointsWebService.model.*;
//Interface for handling the logic and inserting data into memory
//Useful if we need to store the data to a persistent storage like a database
public interface PointsDao {

	String pointsAdd(Companies company);
	
	String pointsSub(Companies company);
	
	List<Companies> getCompanies();	
	
	List<Expenditures> getExpenditures(Integer points);
	
	HashMap<String, Integer> getBalances();
}
