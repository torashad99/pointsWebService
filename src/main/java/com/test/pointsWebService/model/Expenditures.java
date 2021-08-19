package com.test.pointsWebService.model;

public class Expenditures {

	String payer;
	
	Integer points;
	
	public Expenditures() {
		super();
	}

	public Expenditures(String payer, Integer points) {
		this.payer = payer;
		this.points = points;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
}
