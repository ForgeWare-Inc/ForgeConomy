package com.ForgeWareInc.ForgeConomy;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerPrefs extends JavaPlugin{
	
	private String name = null;
	private Bank selectedBank = null;
	private BankAccount selectedAccount = null;
	
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
