package com.ForgeWareInc.ForgeConomy;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Bank{
	
	private String bankOwner = "nobody";
	//private ArrayList<String> bankMods = new ArrayList<String>();
	private String bankName = "void";
	private String bankType = "none";
	
	private ArrayList<BankAccount> Accounts = new ArrayList<BankAccount>();
	
	public Bank(Player player, String name, String type){
		bankOwner = player.getName();
		bankName = name;
		bankType = type;
	}
	
	public Bank(){ }

	public String getOwner(){
		return bankOwner;
	}
	
	public String getName(){
		return bankName;
	}
	
	public String getType(){
		return bankType;
	}
	
	public void newAccount(String owner, int startBalance){
		BankAccount account = new BankAccount(owner, startBalance);
		Accounts.add(account);
	}
	
	public ArrayList<BankAccount> getAccounts(){
		return Accounts;
	}
}
