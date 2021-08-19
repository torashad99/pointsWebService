package com.test.pointsWebService.dao;

import java.util.List;
import java.util.HashMap;

import com.test.pointsWebService.model.*;

public interface PointsDao {

	String pointsAdd(Companies company);
	
	String pointsSub(Companies company);
	
	List<Companies> getCompanies();	
	
	List<Expenditures> getExpenditures(Integer points);
	
	HashMap<String, Integer> getBalances();
}
