package com.taskbuddy.services;

import java.util.List;

import com.taskbuddy.entities.Taskerinfo;

public interface TaskerService 
{
	List<String> fetchCategories();
	List<String> fetchCategoriesInLocation(String location);
	List<Taskerinfo> fetchTaskerByCategory(String location,String category);
	Taskerinfo findTasker(int taskerId);
	List<String> fetchCities();
	List<String> fetchLocationsInCity(String city);
	List<String> fetchCategoryByLocation(String location);
	void updateTasker(Taskerinfo taskerinfo);
}
