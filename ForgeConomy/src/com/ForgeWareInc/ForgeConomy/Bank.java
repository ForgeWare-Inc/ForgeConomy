package com.ForgeWareInc.ForgeConomy;

import java.util.ArrayList;
import java.util.Map.Entry;

public class Bank{
	
	private String bankName = "NEW_BANK";
	private int bankID = 999;
	private ArrayList<String> Members = new ArrayList<String>();

	public Bank(String name, String owner){
		bankName = name;
		generateID();
		Members.add(owner);
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
	
	public void setBankName(String newName){
		bankName = newName;
	}
	
	public boolean setBankOwner(String newOwner){
		if(!Members.get(0).toString().equals(newOwner)){
			Members.set(0, newOwner);
		}
		return false;
	}
	
	public boolean addMember(String memberName){
		if(!Members.contains(memberName)){
			Members.add(memberName);
			return true;
		}
		return false;
	}
}
