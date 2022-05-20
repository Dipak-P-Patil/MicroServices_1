package com.jbk.branch_services.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.branch_services.entity.Branch;
import com.jbk.branch_services.service.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {
	
	@Autowired
	BranchService service;
	
	//List<Branch> list= new ArrayList<>();
	
	@PostMapping(value="/saveBranch")
	public ResponseEntity<Branch> saveBranch(@RequestBody Branch branch){
		Branch br =service.saveBranch(branch);
		
		if (br != null) {
			return new ResponseEntity<>(br, HttpStatus.CREATED);

		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
			
	}
	@GetMapping(value = "/getBranch/{branchId}")
	public ResponseEntity<Branch> getStudent(@PathVariable String branchId) {

		Branch branch = service.getBranchById(branchId);
		if (branch != null) {
			return new ResponseEntity<>(branch, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
	
	}	
	

}
