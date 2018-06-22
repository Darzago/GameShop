package logic;

import java.io.Serializable;

public class Article implements Serializable{
	
	private int id;
	private String name;
	private double price;
	private int amount;
	
	private boolean valid=false;
	
	public void validate() 
	{
		this.valid = amount >= 0 && !name.isEmpty() && price > 0;
	}
	
	public boolean isValid()
	{
		return this.valid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Article(int id, String name, double price, int amount) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
}
