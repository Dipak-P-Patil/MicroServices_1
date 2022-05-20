package com.jbk.branch_services.service;

import java.util.List;

import com.jbk.branch_services.entity.Branch;


public interface BranchService {
	
	public Branch saveBranch(Branch branch);
	public Branch getBranchById(String branchId);
	public List<Branch> getAllBranch();
	

}
