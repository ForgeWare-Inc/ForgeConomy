package com.ForgeWareInc.ForgeConomy;

import java.util.ArrayList;
import java.util.Map.Entry;

public class Bank{
	
	private String bankName = "NEW_BANK";
	private String bankDescription = "None";
	private int bankID = -1;
	private boolean bankActive = false;
	private ArrayList<String> Members = new ArrayList<String>();

	public Bank(String name, String description, String owner, int ID, boolean active){
		bankName = name;
		if(ID < 0){
			this.bankID = generateID();
		}else{
			this.bankID = ID;
		}
		ForgeConomy.bankIDs.put(bankID, this);
		this.bankActive = active;
		this.Members.add(owner);
		if(description.equals("NEW")){
			this.bankDescription = "#aBank: " + name + " is owned by: " + owner;
		}else{
			this.bankDescription = description;
		}
	}
	
	private int generateID(){
		int max = 0;
		for(Entry<Integer, Bank> key : ForgeConomy.bankIDs.entrySet()){
			if(max < key.getKey()){
				max = key.getKey();
			}
		}
		return max + 1;
	}
	
	public String getBankName(){
		return this.bankName;
	}
	
	public int getBankID(){
		return this.bankID;
	}
	
	public String getOwner(){
		return this.Members.get(0).toString();
	}
	
	public String getDescription(){
		return this.bankDescription;
	}
	
	public boolean getBankState(){
		return this.bankActive;
	}
	
	public void setBankName(String newName){
		this.bankName = newName;
	}
	
	public boolean setBankOwner(String newOwner){
		if(!this.Members.get(0).toString().equals(newOwner)){
			this.Members.set(0, newOwner);
			return true;
		}
		return false;
	}
	
	public void setDescription(String description){
		this.bankDescription = description;
	}
	
	public boolean addMember(String memberName){
		if(!this.Members.contains(memberName)){
			this.Members.add(memberName);
			return true;
		}
		return false;
	}
	
	public boolean removeMember(String memberName){
		if(!this.Members.contains(memberName)){
			this.Members.remove(memberName);
			return true;
		}
		return false;
	}
	
	public void makeActive(){
		this.bankActive = true;
	}
	
	public void makeInactive(){
		this.bankActive = false;
	}
	
	public boolean isMember(String name){
		if(this.Members.contains(name)){
			return true;
		}
		return false;
	}
	
	public boolean isActive(){
		return this.bankActive;
	}
}
