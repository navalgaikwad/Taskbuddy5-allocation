package com.taskbuddy.services;

import com.taskbuddy.entities.Operation;

public interface OperationService 
{
	void saveOperation(Operation operation);
	Operation fetchOperation(int opid);
	void updateOperation(Operation operation);
}
