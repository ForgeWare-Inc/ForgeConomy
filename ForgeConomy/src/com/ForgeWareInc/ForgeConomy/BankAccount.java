package com.ForgeWareInc.ForgeConomy;

import java.util.ArrayList;

public class BankAccount{

	private ArrayList<String> members = new ArrayList<String>();
	private int balance = 0;
	
	public BankAccount(String user, int amount){
		members.add(user);
		balance = amount;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public String getOwner(){
		return members.get(0);
	}
	
	public ArrayList<String> getMembers(){
		return members;
	}
	
	public int deposit(int amount){
		balance = balance + amount;
		return balance;
	}
	
	public int withdraw(int amount){
		if(balance >= amount){
			balance = balance - amount;
		}
		return balance;
	}
	
	public void addMember(String member){
		for(String memberName : members){
			if(!memberName.equals(member)){
				members.add(member);
			}else{
				//already member
			}
		}
	}
}
