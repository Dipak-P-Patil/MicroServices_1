package com.jbk.branch_services.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.branch_services.entity.Branch;

@Repository
public class BranchDao_imp implements BranchDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Branch saveBranch(Branch branch) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.save(branch);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			session.close();
		}

		return branch;
	}

	@Override
	public Branch getBranchById(String branchId) {

		Session session = sf.openSession();
		Branch branch = null;

		try {
			branch = session.get(Branch.class, branchId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}

		return branch;
	}

	@Override
	public List<Branch> getAllBranch() {

		return null;
	}

}
