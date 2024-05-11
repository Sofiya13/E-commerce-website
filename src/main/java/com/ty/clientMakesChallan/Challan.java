package com.ty.clientMakesChallan;


public class Challan {
    private int id;
    private String from_location;
    private String to_location;
  private String username;
    private int quantity;
    private String productDetails;
    private Double rate;
    private Double finalAmount;
	public Challan(String from_location, String to_location,  int quantity,
			String productDetails, double rate, double finalAmount, String username) {
		
		 
	        this.from_location=from_location;
	        this.to_location=to_location;
	       this.username=username;
	        this.quantity = quantity;
	        this.productDetails = productDetails;
	        this.rate = rate;
	        this.finalAmount = finalAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}
	public String getFrom_location() {
		return from_location;
	}
	public void setFrom_location(String from_location) {
		this.from_location = from_location;
	}
	public String getTo_location() {
		return to_location;
	}
	public void setTo_location(String to_location) {
		this.to_location = to_location;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}