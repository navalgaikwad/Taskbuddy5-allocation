package com.taskbuddy.daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taskbuddy.entities.Taskerinfo;
import com.taskbuddy.entities.Userinfo;

@Repository
public class TaskerDaoImpl implements TaskerDao 
{

	@Autowired
	private SessionFactory factory;
	
	@Transactional
	public List<String> getCategories() 
	{
		Session session=factory.getCurrentSession();
		String sql="SELECT DISTINCT CATEGORY FROM TASKERINFO";
		SQLQuery query=session.createSQLQuery(sql);
		return query.list();
	}
	
	@Transactional
	public List<String> getCategoriesInLocation(String location) 
	{
		Session session=factory.getCurrentSession();
		String sql="SELECT DISTINCT CATEGORY FROM TASKERINFO A JOIN USERINFO B ON A.LOGINID=B.LOGINID WHERE B.LOCATION=:X";
		SQLQuery query=session.createSQLQuery(sql);
		query.setString("X",location);
		return query.list();
	}

	@Transactional
	public List<Taskerinfo> getTaskersByCategory(String location,String category) {
		Session session=factory.getCurrentSession();
		String sql="SELECT * FROM TASKERINFO A JOIN USERINFO B ON A.LOGINID=B.LOGINID WHERE B.LOCATION=:X AND A.CATEGORY=:Y AND A.STATUS=1";
		SQLQuery query=session.createSQLQuery(sql);
		query.addEntity(Taskerinfo.class);
		query.setString("X", location);
		query.setString("Y", category);
		List<Taskerinfo> taskers=query.list();
		return query.list();
	}

	@Transactional
	public Taskerinfo findTasker(int taskerid) {
		Session session=factory.getCurrentSession();
		return (Taskerinfo) session.get(Taskerinfo.class, taskerid);
	}

	@Transactional
	public List<String> getCities() //cities with service avaliable
	{
		Session session=factory.getCurrentSession();
		String sql="SELECT DISTINCT CITY FROM USERINFO A JOIN LOGININFO B ON A.LOGINID=B.LOGINID WHERE B.ROLE=1";
		SQLQuery query=session.createSQLQuery(sql);
		return query.list();
	}
	
	@Transactional
	public List<String> getCategoryByLocation(String location) {
		Session session=factory.getCurrentSession();
		String sql="SELECT DISTINCT CATEGORY FROM TASKERINFO A JOIN USERINFO B ON A.LOGINID=B.LOGINID WHERE B.LOCATION=:X";
		//NAMED QUERY
		SQLQuery query=session.createSQLQuery(sql);
		query.setString("X", location);
		return query.list();
	}

	@Transactional
	public List<String> getLocationsInCity(String city) {
		Session session=factory.getCurrentSession();
		String sql="SELECT DISTINCT LOCATION FROM USERINFO A JOIN LOGININFO B ON A.LOGINID=B.LOGINID WHERE A.CITY=:X AND B.ROLE=1";
		//NAMED QUERY
		SQLQuery query=session.createSQLQuery(sql);
		query.setString("X", city);
		return query.list();
	}

	@Transactional
	public void updateTasker(Taskerinfo taskerinfo) {
		Session session=factory.getCurrentSession();
		session.update(taskerinfo);
	}

}
