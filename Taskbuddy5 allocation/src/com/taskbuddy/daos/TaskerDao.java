package com.taskbuddy.daos;

import java.util.List;

import com.taskbuddy.entities.Taskerinfo;

public interface TaskerDao 
{
	List<String> getCategories();
	List<String> getCategoriesInLocation(String location);
	List<Taskerinfo> getTaskersByCategory(String location,String category);
	Taskerinfo findTasker(int taskerid);
	List<String> getCities();
	List<String> getLocationsInCity(String city);
	List<String> getCategoryByLocation(String location);
	void updateTasker(Taskerinfo taskerinfo);
}
