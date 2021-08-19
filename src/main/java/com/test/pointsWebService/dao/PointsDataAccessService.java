package com.test.pointsWebService.dao;

import com.test.pointsWebService.model.Companies;
import com.test.pointsWebService.model.Expenditures;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.lang.Math;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

@Repository("repo")
public class PointsDataAccessService implements PointsDao{

	private static List<Companies> theList = new ArrayList<>();
	
	@Override
	public String pointsAdd(Companies company) {
	
		if(theList.isEmpty()) {
			
			theList.add(company);
			return "Transaction is added";
			
		}
		
		else {
		
			theList.add(company);
			
			
			theList.sort(
			        Comparator
	                .comparing( ( Companies c ) -> c.getTimestamp().toLocalDate() )
	                .thenComparing(
	                        Comparator
	                                .comparing( ( Companies c ) -> c.getTimestamp().toLocalTime() )
	                )

			);
			
			
			return "Transaction is added and sorted by time in ascending order";
		
		}
		
	}

	@Override
	public List<Companies> getCompanies() {
		return theList;
	}

	@Override
	public String pointsSub(Companies company) {
		
		Integer pointstoSub = (~(company.getPoints() - 1));
		Integer check = pointstoSub;
		//List<Companies> copyList = theList;
		//System.out.println(copyList);
		List<Companies> toRemove = new ArrayList<>();
		int flag = 0;
		
		for (Companies c : theList) {
			
			if(company.getPayer().equals(c.getPayer()) && c.getPoints() > 0 && pointstoSub > 0) {
				
				Integer temp = pointstoSub - c.getPoints();
				
				if(temp >= 0) {
					
					pointstoSub = pointstoSub - c.getPoints();
					//theList.remove(c);
					//toRemove.add(c);
					c.setPoints(0);
					
				}
				
				else{
					
					Integer toPut = c.getPoints() - pointstoSub;
					c.setPoints(toPut);
					//flag = 1;
					//return "Points subtracted";
					pointstoSub = 0;
					
				}
				
			}
			
		}
		
		if(check.equals(pointstoSub))
			return "No payer(s) to subtract points from";
		else if(pointstoSub > 0)
			return "Points subtracted with leftover: " + ~(pointstoSub - 1);
		else
			return "Points subtracted";
		
	}

	@Override
	public List<Expenditures> getExpenditures(Integer points) {
		
		//Integer check = points;
		//List<Companies> copyList = theList;
		//System.out.println(copyList);
		//List<Expenditures> expList = new ArrayList<>();
		//int flag = 0;
		HashMap<String, Expenditures> toAdd = new HashMap<>();
		//List<Companies> toRemove = new ArrayList<>();
		
		
		for (Companies c : theList) {
				
			if(points > 0) {
			
				if(c.getPoints() > 0) {
				
					Integer temp = points - c.getPoints();
						
					if(temp >= 0) {
							
						points = points - c.getPoints();
						
						if(toAdd.containsKey(c.getPayer()))
							toAdd.get(c.getPayer()).setPoints(~(c.getPoints() - 1));
							
						else
						    toAdd.put(c.getPayer(), new Expenditures(c.getPayer(), ~(c.getPoints() - 1)));
						
						c.setPoints(0);
							
					}
						
					else {
							
						Integer toPut = c.getPoints() - points;
						c.setPoints(toPut);
						
						if(toAdd.containsKey(c.getPayer()))
							toAdd.get(c.getPayer()).setPoints(~(points - 1));
							
						else
						    toAdd.put(c.getPayer(), new Expenditures(c.getPayer(), ~(points - 1)));
						
						points = 0;
							
					}
				}
				
				else {
					
					Integer toPut;
					
					if(toAdd.containsKey(c.getPayer()))
						toPut = toAdd.get(c.getPayer()).getPoints() + ~(c.getPoints() - 1); 
					else
						toPut = 0;
					
					points = points + ~(c.getPoints() - 1);
					
					if(toAdd.containsKey(c.getPayer()))
						toAdd.get(c.getPayer()).setPoints(toPut);
						
					else
					    toAdd.put(c.getPayer(), new Expenditures(c.getPayer(), toPut));
					
					c.setPoints(0);
					
				}
			}
			
			else break;
			
		}
		
		//theList.removeAll(toRemove);
		
		return new ArrayList<Expenditures>(toAdd.values()); 
		
	}

	@Override
	public HashMap<String, Integer> getBalances() {
		
		HashMap<String, Integer> bal = new HashMap<>();
		
		for(Companies c : theList) {
			
			if(bal.containsKey(c.getPayer())) {
				
				Integer val = bal.get(c.getPayer());
				bal.put(c.getPayer(), val + c.getPoints());
			}
			
			else
			    bal.put(c.getPayer(), c.getPoints());
			
		}
		
		return bal;
		
	}
	
}
