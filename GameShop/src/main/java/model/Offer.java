package model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;


public class Offer implements Serializable{
	private String name;
	private String email;
	private double price;
	private int amount;
	
	public String getName() 
	{
		return name;
	}
	public void setName(String gameName) 
	{
		this.name = gameName;
	}
	/**
	 * @return the user Email
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
