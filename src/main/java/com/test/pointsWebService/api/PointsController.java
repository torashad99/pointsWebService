package com.test.pointsWebService.api;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.pointsWebService.service.*;
import com.test.pointsWebService.model.*;

@RequestMapping("points/api")
@RestController
public class PointsController {

	private final PointsService pointsService;
	
	@Autowired
	PointsController(PointsService pointsService){
		this.pointsService = pointsService;
	}
	
	@PostMapping
	public String addTransaction(@RequestBody Companies company) {
		return pointsService.pointsAdd(company);
	}
	
	@GetMapping
	public List<Companies> getCompanies() {
		return pointsService.getCompanies();
	}
	
	@PostMapping(path = "spend")
	public List<Expenditures> getExpenditures(@RequestBody PointsToSpend p) {
		return pointsService.getExpenditures(p);
	}
	
	@GetMapping(path = "balance")
	public HashMap<String, Integer> getBalance(){
		return pointsService.getBalances();
	}
	
}
