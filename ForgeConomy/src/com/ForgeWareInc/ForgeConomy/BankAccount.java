package com.ForgeWareInc.ForgeConomy;

import java.util.ArrayList;

/**
	A class representing a bank account that supports multiple members.
	All normal bank account methods (deposit, withdraw, getBalance, etc.)
	are present. The account's owner (index 0 in ArrayList of members) has
	additional privilages to add/remove members and delete the account.
	Regular members have access to the account's balance (both deposit and
	withdraw).
*/ 
public class BankAccount{
	
	private ArrayList<String> members = new ArrayList<String>();
	private int balance = 0;
	
	/**
		Constructor; creates a bank account with an owner and a balance
		@param user the bank account's owner and primary user
		@param amount the bank account's initial balance
	*/
	public BankAccount(String user, int amount){
		members.add(user);
		balance = amount;
	}
	
	/**
		Accessor for balance
		@return the account's current balance
	*/
	public int getBalance(){
		return balance;
	}
	
	/**
		Accessor for the acount's owner
		@return the account's owner
	*/
	public String getOwner(){
		return members.get(0);
	}
	
	/**
		Accessor for members
		@return an ArrayList containing the account's members
	*/
		public ArrayList<String> getMembers(){
		return members;
	}
	
	/**
		Deposits funds into the account
		@param amount the amount to be deposited
		@return the account's balance after the deposit
	*/
	public int deposit(int amount){
		balance = balance + amount;
		return balance;
	}
	
	/**
		Withdraws funds from the account if sufficient funds exist
		@param amount the amount to be withdrawn
		@return whether the withdraw was successful
	*/
	public boolean withdraw(int amount){
		if(balance >= amount){
			balance = balance - amount;
			return true;
		}else{
			return false;
		}
	}
	
	/**
		Adds a member to the account
		@param member the member to be added
	*/
	public void addMember(String member){
		if(!members.contains(member)){
			members.add(member);
		}else{
			//already member
		}
	}
	
	/**
		Describes the bank account, listing the current
		balance, owner, and all members
		@return a String containing information about the account
	*/
	public String toString(){
		String output = ("Balance: "+balance+"\nOwner: "+members.get(0));
		if(members.size()==1){
			return output;
		}
		output += ("\nMembers:\n\t");
		// adds members to string in rows of four
		for(int i=1; i<members.size();){
			for(int k=0; k<4; k++){
				if(i==(members.size()-1)){
					output += members.get(i);
					return output;
				}else{
				output += (members.get(i)+", ");
				i++;
				}
			}
			output += "\n\t";
		}
		return output;
	}
}
