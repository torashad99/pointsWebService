package com.test.pointsWebService.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.pointsWebService.dao.PointsDao;
import com.test.pointsWebService.model.*;

@Service
public class PointsService {

	private final PointsDao pointsDao;
	
	@Autowired
	PointsService(@Qualifier("repo") PointsDao pointsDao){
		this.pointsDao = pointsDao;
	}
	
	public String pointsAdd(Companies company) {
		
		if(company.getPoints() != 0)
			return pointsDao.pointsAdd(company);
		
		//else if(company.getPoints() < 0)
		//	return pointsDao.pointsSub(company);
		
		else
			return "Cannot enter 0. Please enter a positive or negative value";
	}
	
	public List<Companies> getCompanies() {
		return pointsDao.getCompanies();
	}
	
	public List<Expenditures> getExpenditures(PointsToSpend p) {
		
		Integer points = p.getPoints();
		
		if(points > 0)
			return pointsDao.getExpenditures(points);
		
		else
			return null;
	}
	
	public HashMap<String, Integer> getBalances() {
		return pointsDao.getBalances();
	}
	
}
