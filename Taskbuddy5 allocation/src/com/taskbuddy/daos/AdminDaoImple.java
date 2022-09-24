package com.taskbuddy.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taskbuddy.entities.Logininfo;
import com.taskbuddy.entities.Operation;
import com.taskbuddy.entities.Taskerinfo;
import com.taskbuddy.entities.Userinfo;

@Repository
public class AdminDaoImple implements AdminDao {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public List<Logininfo> getList() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Logininfo.class);
		
		return cr.list();
	}

	@Transactional
	public List<Operation> getOperationList() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Operation.class);
		
		return cr.list();
	}

	@Transactional
	public List<Taskerinfo> getTaskerList() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Taskerinfo.class);
		
		return cr.list();
	}

	@Transactional
	public List<Userinfo> getUserList() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Userinfo.class);
		
		return cr.list();
	}

	@Transactional
	public void deleteTasker(int loginid) {
		Session session=sessionFactory.getCurrentSession();
		
		Object obj = session.get(Logininfo.class, loginid);
		
		session.delete(obj);

	}

	@Transactional
	public Logininfo findTasker(int loginid) {
		
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Logininfo.class);
		cr.add(Restrictions.eq("loginid", loginid));
		List list = cr.list();
		if(list.isEmpty())
		{
			return null;
		}
		
		return (Logininfo) list.get(0);
	}

	@Transactional
	public void addUser(Logininfo logininfo) {
		Session session=sessionFactory.getCurrentSession();
		session.save(logininfo);
		
	}

}
