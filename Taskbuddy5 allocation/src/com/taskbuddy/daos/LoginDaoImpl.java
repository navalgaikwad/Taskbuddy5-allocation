package com.taskbuddy.daos;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taskbuddy.entities.Logininfo;
import com.taskbuddy.entities.Userinfo;

@Repository
public class LoginDaoImpl implements LoginDao 
{
	@Autowired
	SessionFactory factory;

	@Transactional
	public void add(Logininfo logininfo) 
	{
		Session session=factory.getCurrentSession();
		session.save(logininfo);
	}

	@Transactional
	public Logininfo find(String username) 
	{
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Logininfo.class);
		cr.add(Restrictions.eq("username", username));
		/*return (Logininfo) session.get(Logininfo.class, username);*/
		List list=cr.list();
		if(list.isEmpty())
			return null;
		return (Logininfo)list.get(0);
	}

	@Transactional
	public void addUser(Userinfo userinfo) 
	{
		Session session=factory.getCurrentSession();
		session.save(userinfo);
	}

	@Transactional
	public Userinfo getUserinfo(Logininfo logininfo) {
		System.out.println("inside dao");
		Object[] userinfos = logininfo.getUserinfos().toArray();
		Userinfo userinfo=(Userinfo)userinfos[0];
		//System.out.println(">>>>>>>>>>>>>>>>>>"+userinfo);
		return userinfo;
	}

	@Transactional
	public Logininfo getLogininfoById(int loginid) {
		Session session=factory.getCurrentSession();
		return (Logininfo) session.get(Logininfo.class,loginid);
	}

	/*@Transactional
	public Userinfo getUserinfo(int loginid) 
	{
		Session session = factory.getCurrentSession();
		Criteria cr=session.createCriteria(Userinfo.class);
		cr.add(Restrictions.eq("loginid", loginid));
		List list=cr.list();
		if(list.isEmpty())
			return null;
		return (Userinfo)list.get(0);
	}
	*/
}

