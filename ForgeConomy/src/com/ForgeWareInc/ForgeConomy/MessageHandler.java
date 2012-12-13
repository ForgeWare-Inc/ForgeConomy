package com.ForgeWareInc.ForgeConomy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageHandler extends JavaPlugin{

	public MessageHandler(){
		
	}
	
	public void showError(String error, ChatColor cc, String playerName){
		Player player = ForgeConomy.getPlayerObject(playerName);
		player.sendMessage(cc + " <ForgeConomy> " + error);
	}
	
	public void showInfo(String info, ChatColor cc, String playerName){
		Player player = ForgeConomy.getPlayerObject(playerName);
		player.sendMessage(cc + " <ForgeConomy> " + info);
	}
	
	public void showSuccess(String success, ChatColor cc, String playerName){
		Player player = ForgeConomy.getPlayerObject(playerName);
		player.sendMessage(cc + " <ForgeConomy> " + success);
	}
}
