package com.taskbuddy.daos;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taskbuddy.entities.Operation;

@Repository
public class OperationDaoImpl implements OperationDao {

	@Autowired
	SessionFactory factory;
	
	@Transactional
	public void add(Operation operation) {
		Session session = factory.getCurrentSession();
		session.save(operation);
	}

	@Transactional
	public Operation getOperartionByid(int opid) {
		Session session = factory.getCurrentSession();
		return (Operation) session.get(Operation.class, opid);
	}

	@Transactional
	public void updateOperation(Operation operation) {
		Session session = factory.getCurrentSession();
		session.update(operation);
	}

}
