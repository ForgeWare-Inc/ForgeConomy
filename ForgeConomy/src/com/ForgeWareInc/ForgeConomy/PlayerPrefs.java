package com.ForgeWareInc.ForgeConomy;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerPrefs extends JavaPlugin{
	
	private String name;
	private Bank selectedBank;
	private BankAccount selectedAccount;
	
	public PlayerPrefs(String playerName){
		setPlayerName(playerName);
	}

	public String getPlayerName(){
		return name;
	}

	private void setPlayerName(String name){
		this.name = name;
	}
	
	public Player getPlayerObject(){
		return getServer().getPlayer(getPlayerName());
	}
	
	public Bank getSelectedBank(){
		return selectedBank;
	}
	
	public BankAccount getSelectedAccount(){
		return selectedAccount;
	}
}
