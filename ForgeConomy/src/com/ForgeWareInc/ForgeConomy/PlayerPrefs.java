package com.ForgeWareInc.ForgeConomy;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerPrefs extends JavaPlugin{
	
	private String name = null;
	private Bank selectedBank = null;
	private BankAccount selectedAccount = null;
	private Wallet wallet = null;
	
	public PlayerPrefs(String playerName){
		setPlayerName(playerName);
	}

	public boolean createWallet(double amount){
		if(wallet == null){
			wallet = new Wallet(this.getPlayerName(), amount);
			return true;
		}
		return false;
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
	
	public Wallet getWallet(){
		return wallet;
	}
}
