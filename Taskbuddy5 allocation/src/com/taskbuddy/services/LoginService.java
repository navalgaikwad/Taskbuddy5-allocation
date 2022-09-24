package com.taskbuddy.services;

import com.taskbuddy.entities.Logininfo;
import com.taskbuddy.entities.Userinfo;

public interface LoginService 
{
	boolean validate(Logininfo logininfo);
	void register(Logininfo logininfo);
	Logininfo getUser(String username);
	Logininfo getLogininfoById(int loginid);
	void addUserToUserinfo(Userinfo userinfo);
	Userinfo getUserinfoFromLoginid(Logininfo logininfo);
}
