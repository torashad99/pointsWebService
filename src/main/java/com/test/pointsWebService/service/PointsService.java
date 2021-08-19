package com.test.pointsWebService.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.pointsWebService.dao.PointsDao;
import com.test.pointsWebService.model.*;

@Service
//Class used to handle input parameters, checking if inputs are valid, giving an error if it's not valid, or giving out a result if it's valid
public class PointsService {

	private final PointsDao pointsDao;
	
	@Autowired
	PointsService(@Qualifier("repo") PointsDao pointsDao){
		this.pointsDao = pointsDao;
	}
	
	//Method for add transaction
	public String pointsAdd(Companies company) {
		
		if(company.getPoints() != 0)
			return pointsDao.pointsAdd(company);
		
		else
			return "Cannot enter 0. Please enter a positive or negative value";
	}
	
	//Method to give out all transactions, sorted by timestamp in ascending order
	public List<Companies> getCompanies() {
		return pointsDao.getCompanies();
	}
	
	//Method to spend points, gives out expenditures, returns an empty list if points cannot be spent
	public List<Expenditures> getExpenditures(PointsToSpend p) {
		
		Integer points = p.getPoints();
		
		if(points > 0)
			return pointsDao.getExpenditures(points);
		
		else
			return null;
	}
	
	//Method to get balances of each company from transactions stored
	public HashMap<String, Integer> getBalances() {
		return pointsDao.getBalances();
	}
	
}
