package com.jbk.branch_services.dao;

import java.util.List;

import com.jbk.branch_services.entity.Branch;

public interface BranchDao {
	public Branch saveBranch(Branch branch);
	public Branch getBranchById(String branchId);
	public List<Branch> getAllBranch();

}
