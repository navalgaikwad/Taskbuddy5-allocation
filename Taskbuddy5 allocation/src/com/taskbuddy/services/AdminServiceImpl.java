package com.taskbuddy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskbuddy.daos.AdminDao;
import com.taskbuddy.entities.Logininfo;
import com.taskbuddy.entities.Operation;
import com.taskbuddy.entities.Taskerinfo;
import com.taskbuddy.entities.Userinfo;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao dao;
	@Override
	public List<Logininfo> getList() {
		
		return dao.getList();
	}

	@Override
	public List<Operation> getOperationList() {
		
		return dao.getOperationList();
	}

	@Override
	public List<Taskerinfo> getTaskerList() {
		
		return dao.getTaskerList();
	}

	@Override
	public List<Userinfo> getUserList() {
		
		return dao.getUserList();
	}

	@Override
	public void deleteTasker(int loginid) {
		
		dao.deleteTasker(loginid);
		
	}

	@Override
	public Logininfo findTasker(int loginid) {
		
		return dao.findTasker(loginid);
	}

	@Override
	public void addUser(Logininfo logininfo) {
		dao.addUser(logininfo);
		
	}

}
