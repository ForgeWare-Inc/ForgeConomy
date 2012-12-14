package com.ForgeWareInc.ForgeConomy;

public class Wallet{
	
	private String owner = "SERVER";
	private double balance = 0;
	
	public Wallet(String owner, double balance){
		this.owner = owner;
		this.balance = balance;
	}
	
	public boolean withdraw(double amount){
		if(this.balance >= amount){
			this.balance -= amount;
			return true;
		}
		return false;
	}
	
	public void deposit(double amount){
		this.balance += amount;
	}
	
	public String getOwner(){
		return owner;
	}
}
