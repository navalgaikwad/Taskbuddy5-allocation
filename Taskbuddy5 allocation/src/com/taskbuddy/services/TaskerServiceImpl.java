package com.taskbuddy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskbuddy.daos.OperationDao;
import com.taskbuddy.daos.TaskerDao;
import com.taskbuddy.entities.Operation;
import com.taskbuddy.entities.Taskerinfo;

@Service
public class TaskerServiceImpl implements TaskerService 
{
	@Autowired
	TaskerDao taskerDao;
	
	@Override
	public List<String> fetchCategories() {
		return taskerDao.getCategories();
	}

	@Override
	public List<Taskerinfo> fetchTaskerByCategory(String location,String category) 
	{
		return taskerDao.getTaskersByCategory(location,category);
	}

	@Override
	public Taskerinfo findTasker(int taskerId) 
	{
		return taskerDao.findTasker(taskerId);
	}

	@Override
	public List<String> fetchCategoryByLocation(String location) 
	{
		return taskerDao.getCategoryByLocation(location);
	}

	@Override
	public List<String> fetchCities() 
	{
		return taskerDao.getCities();
	}

	@Override
	public List<String> fetchLocationsInCity(String city) 
	{
		return taskerDao.getLocationsInCity(city);
	}

	@Override
	public List<String> fetchCategoriesInLocation(String location) 
	{
		return taskerDao.getCategoriesInLocation(location);
	}

	@Override
	public void updateTasker(Taskerinfo taskerinfo) {
		taskerDao.updateTasker(taskerinfo);
		
	}

}
