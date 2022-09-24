package com.taskbuddy.daos;

import com.taskbuddy.entities.Logininfo;
import com.taskbuddy.entities.Userinfo;

public interface LoginDao 
{
	void add(Logininfo logininfo);
	Logininfo find(String username);
	void addUser(Userinfo userinfo);
	Userinfo getUserinfo(Logininfo logininfo);
	Logininfo getLogininfoById(int loginid);
}
