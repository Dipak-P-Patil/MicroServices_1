package com.jbk.branch_services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.branch_services.dao.BranchDao;
import com.jbk.branch_services.entity.Branch;

@Service
public class BranchService_imp implements BranchService {
	
	@Autowired
	private BranchDao dao;
	

	@Override
	public Branch saveBranch(Branch branch) {
	
		return dao.saveBranch(branch);
	}

	@Override
	public Branch getBranchById(String branchId) {
		
		return dao.getBranchById(branchId);
	}

	@Override
	public List<Branch> getAllBranch() {
		
		return null;
	}

}
