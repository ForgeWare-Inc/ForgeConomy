package com.ForgeWareInc.ForgeConomy;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.bukkit.ChatColor;

public class Bank{
	
	private String bankName = "NEW_BANK";
	private String bankDescription = "None";
	private int bankID = -1;
	private boolean bankActive = false;
	private ArrayList<String> Members = new ArrayList<String>();

	public Bank(String name, String description, String owner, int ID, boolean active){
		bankName = name;
		if(ID < 0){
			generateID();
		}else{
			bankID = ID;
		}
		bankActive = active;
		Members.add(owner);
		if(description.equals("NEW")){
			bankDescription = "#aBank: " + name + " is owned by: " + owner;
		}else{
			bankDescription = description;
		}
	}
	
	private void generateID(){
		int max = 0;
		for(Entry<Integer, Bank> key : ForgeConomy.bankIDs.entrySet()){
			if(max < key.getKey()){
				max = key.getKey();
			}
		}
		bankID = max + 1;
		ForgeConomy.bankIDs.put(bankID, this);
	}
	
	public String getBankName(){
		return bankName;
	}
	
	public int getBankID(){
		return bankID;
	}
	
	public String getOwner(){
		return Members.get(0).toString();
	}
	
	public String getDescription(){
		return bankDescription;
	}
	
	public boolean getBankState(){
		return bankActive;
	}
	
	public void setBankName(String newName){
		bankName = newName;
	}
	
	public boolean setBankOwner(String newOwner){
		if(!Members.get(0).toString().equals(newOwner)){
			Members.set(0, newOwner);
			return true;
		}
		return false;
	}
	
	public void setDescription(String description){
		bankDescription = description;
	}
	
	public boolean addMember(String memberName){
		if(!Members.contains(memberName)){
			Members.add(memberName);
			return true;
		}
		return false;
	}
	
	public void makeActive(){
		bankActive = true;
	}
	
	public void makeInactive(){
		bankActive = false;
	}
	
	public boolean isMember(String name){
		if(Members.contains(name)){
			return true;
		}
		return false;
	}
	
	public boolean isActive(){
		return bankActive;
	}
}
