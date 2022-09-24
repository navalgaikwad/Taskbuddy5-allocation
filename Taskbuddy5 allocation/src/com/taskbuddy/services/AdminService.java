package com.taskbuddy.services;

import java.util.List;

import com.taskbuddy.entities.Logininfo;
import com.taskbuddy.entities.Operation;
import com.taskbuddy.entities.Taskerinfo;
import com.taskbuddy.entities.Userinfo;

public interface AdminService {
	public List<Logininfo> getList();
	public List<Operation> getOperationList();
	public List<Taskerinfo>getTaskerList();
	public List<Userinfo>getUserList();
	public void deleteTasker(int loginid);
	public Logininfo findTasker(int loginid);
	public void addUser(Logininfo logininfo);

}
