package com.test.pointsWebService.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

//Object model for companies
//ex: { "payer": "DANNON", "points": 1000, "timestamp": "2020-11-02T14:00:00Z" }

public class Companies {
	
	String payer;
	
	Integer points;
	
	LocalDateTime timestamp;
	
	public Companies() {
		super();
	}

	public Companies(String payer, Integer points, String timestamp) {
		this.payer = payer;
		this.points = points;
		this.timestamp = LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss'Z'").withResolverStyle(ResolverStyle.STRICT));
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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
