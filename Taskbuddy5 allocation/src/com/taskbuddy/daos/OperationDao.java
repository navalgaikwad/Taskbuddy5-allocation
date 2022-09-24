package com.taskbuddy.daos;

import com.taskbuddy.entities.Operation;

public interface OperationDao 
{
	void add(Operation operation);
	Operation getOperartionByid(int opid);
	void updateOperation(Operation operation);
}
