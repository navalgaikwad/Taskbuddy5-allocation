package com.taskbuddy.models;

public class LocationModel 
{
	private String location;
	
	public LocationModel() {
		this("");
	}

	public LocationModel(String location) 
	{
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
