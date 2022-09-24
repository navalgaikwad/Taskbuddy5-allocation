package com.taskbuddy.models;

public class Review 
{
	private String customer;
	private String review;
	private int rating;
	
	public Review() 
	{
		this("","",0);
	}

	public Review(String customer, String review, int rating) 
	{
		this.customer = customer;
		this.review = review;
		this.rating=rating;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
