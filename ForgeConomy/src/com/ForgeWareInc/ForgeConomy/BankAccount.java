package com.ForgeWareInc.ForgeConomy;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.bukkit.ChatColor;

/**
	A class representing a bank account that supports multiple members.
	All normal bank account methods (deposit, withdraw, getBalance, etc.)
	are present. The account's owner (index 0 in ArrayList of members) has
	additional privileges to add/remove members and delete the account.
	Regular members have access to the account's balance (both deposit and
	withdraw).
*/ 
public class BankAccount{
	
	private int accountID = 0;
	private int ownerBankID = 0;
	private ArrayList<String> members = new ArrayList<String>();
	private double balance = 0;
	
	/**
		Constructor; creates a bank account with an owner and a balance
		@param user the bank account's owner and primary user
		@param amount the bank account's initial balance
		@param bankID the ID of the bank that owns this account
		@param accountID the ID of the account
	*/
	public BankAccount(String user, double amount, int bankID, int accountID){
		members.add(user);
		balance = amount;
		if(accountID < 0){
			this.accountID = generateID();
		}else{
			this.accountID = accountID;
		}
		ownerBankID = bankID;
		ForgeConomy.accountIDs.put(this.accountID, this);
	}
	
	private int generateID(){
		int max = 0;
		for(Entry<Integer, BankAccount> key : ForgeConomy.accountIDs.entrySet()){
			if(max < key.getKey()){
				max = key.getKey();
			}
		}
		return max + 1;
	}
	
	/**
		Accessor for balance
		@return the account's current balance
	*/
	public double getBalance(){
		return balance;
	}
	
	/**
		Accessor for the acount's owner
		@return the account's owner
	*/
	public String getOwner(){
		return members.get(0).toString();
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
	public double deposit(double amount){
		balance = balance + amount;
		return balance;
	}
	
	/**
		Withdraws funds from the account if sufficient funds exist
		@param amount the amount to be withdrawn
		@return whether the withdraw was successful
	*/
	public boolean withdraw(double amount){
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
	public boolean addMember(String member){
		if(!members.contains(member)){
			members.add(member);
			return true;
		}
		return false;
	}
	
	public boolean removeMember(String member){
		if(members.contains(member)){
			members.remove(member);
			return true;
		}
		return false;
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
