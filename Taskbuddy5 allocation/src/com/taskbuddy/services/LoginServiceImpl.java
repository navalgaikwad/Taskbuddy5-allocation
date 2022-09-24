package com.taskbuddy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taskbuddy.daos.LoginDao;
import com.taskbuddy.entities.Logininfo;
import com.taskbuddy.entities.Userinfo;

@Repository
public class LoginServiceImpl implements LoginService 
{
	@Autowired
	private LoginDao loginDao;

	@Override
	public boolean validate(Logininfo logininfo) 
	{
		Logininfo dbLogin=loginDao.find(logininfo.getUsername());
		if(dbLogin!=null && dbLogin.getPassword().equals(logininfo.getPassword()))
			return true;
		return false;
	}

	@Override
	public void register(Logininfo logininfo) 
	{
		loginDao.add(logininfo);
	}

	@Override
	public Logininfo getUser(String username) 
	{
		return loginDao.find(username);
	}

	@Override
	public void addUserToUserinfo(Userinfo userinfo) 
	{
		loginDao.addUser(userinfo);
	}

	@Override
	public Userinfo getUserinfoFromLoginid(Logininfo logininfo) 
	{
		System.out.println("inside service");
		return loginDao.getUserinfo(logininfo);
	}

	@Override
	public Logininfo getLogininfoById(int loginid) {
		return loginDao.getLogininfoById(loginid);
	}

}
