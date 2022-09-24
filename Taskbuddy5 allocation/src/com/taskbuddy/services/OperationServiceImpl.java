package com.taskbuddy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskbuddy.daos.OperationDao;
import com.taskbuddy.entities.Operation;

@Service
public class OperationServiceImpl implements OperationService 
{
	@Autowired
	OperationDao operationDao;

	@Override
	public void saveOperation(Operation operation) 
	{
		operationDao.add(operation);
	}

	@Override
	public Operation fetchOperation(int opid) 
	{
		return operationDao.getOperartionByid(opid);
	}

	@Override
	public void updateOperation(Operation operation) {
		operationDao.updateOperation(operation);
		
	}

}
