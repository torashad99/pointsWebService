package com.test.pointsWebService.model;

//Object model to call spend points
//ex : { "points": 5000 }
public class PointsToSpend {
	
	private Integer points;
	
	public PointsToSpend() {
		super();
	}

	public PointsToSpend(Integer points) {
		this.points = points;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
}
