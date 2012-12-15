package com.ForgeWareInc.ForgeConomy;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ForgeConomy extends JavaPlugin implements Listener{
	
	public static HashMap<Integer, Bank> bankIDs = new HashMap<Integer, Bank>();
	public static HashMap<Integer, BankAccount> accountIDs = new HashMap<Integer, BankAccount>();
	public static HashMap<String, PlayerPrefs> playerPrefs = new HashMap<String, PlayerPrefs>();
	
	public static MessageHandler mH = new MessageHandler();
	
	double pluginVersion = 1.0;
	
	@Override
    public void onEnable(){
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getLogger().info("[WELCOME] ForgeConomy " + this.pluginVersion + " enabled!");
    }
 
    @Override
    public void onDisable() {
    	this.getLogger().info("[BYE] ForgeConomy " + pluginVersion + " disabled!");
    }
    
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event){
    	String playerName = event.getPlayer().getName();
    	PlayerPrefs pR = new PlayerPrefs(playerName);
    	ForgeConomy.playerPrefs.put(playerName, pR);
    }
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
    	String playerName = event.getPlayer().getName();
    	if(ForgeConomy.playerPrefs.containsKey(this.playerName)){
    		ForgeConomy.playerPrefs.remove(this.playerName);
    	}
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	if(!(sender instanceof Player)){
    		sender.sendMessage("This command can only be run by a player.");
    		return false;
    	}
    	
    	Player player = (Player) sender;
    	if(!args[0].isEmpty()){
        	//determine which sub command was called    	
        	switch(args[0].toLowerCase()){
        		case "bank" 	:	bank(args, player); break;
        		case "account"	:	bankAccount(args, player); break;
        		case "shop" 	:	shop(args); break;
        		case "econ" 	:	economy(args); break;
        		case "economy" 	:	economy(args); break;
        	}	
    	}
    	return false;
    }
    
    private void bank(String[] args, Player player){
    	if(!args[1].isEmpty()){
    		switch(args[1].toLowerCase()){
    			//forgeconomy bank create
    			case "create"	:	bankCreate(player, args[2], args[3]);
    								break;
    			//forgeconomy bank select
    			case "select"	: 	bankSelect(player, args[2]);
    								break;
    			//forgeconomy bank new
    			case "new"		:	bankNewAccount(player);
    								break;
    		}
    	}
    }
    
    private void bankCreate(Player player, String name, String type){
    	if((!name.isEmpty()) && (!type.isEmpty())){
			if((type.equalsIgnoreCase("new")) || (type.equalsIgnoreCase("linked"))){
				switch(type.toLowerCase()){
					case "new"		: type = "new";
									break;
					case "linked"	: type = "linked";
									break;
					default			: type = "void";
				}
				if(!type.equals("void")){
			    	Bank bank = new Bank(player, name, type);
			    	banks.add(bank);
				}else{
					player.sendMessage(ChatColor.RED + "Invalid bank type entered.");
				}
			}
		}
    }
    
    private void bankSelect(Player player, String name){
    	if(banks.contains(name)){
    		if(!userSelectedBank.containsKey(player.getName())){
    			userSelectedBank.put(player.getName(), name);
    		}else{
    			userSelectedBank.remove(player.getName());
    			userSelectedBank.put(player.getName(), name);
    		}
    	}
    }
    
    private void bankNewAccount(Player player){
    	if(userSelectedBank.containsKey(player.getName())){
    		Bank bank = new Bank();
    		for(Bank eBank : banks){
    			if(eBank.getName().equals(userSelectedBank.get(player.getName()))){
    				bank = eBank;
    				break;
    			}else{
    				return;
    			}
    		}
    		if(!bank.getOwner().equals(player.getName())){
    			bank.newAccount(player.getName(), 0);
    		}
    	}
    }
    
    private void bankAccount(String[] args, Player player){
    	String action = args[2].toLowerCase();
    	switch(action){
    		case "select"	:	bankSelectAccount(player, args[3]); break;
    	}
    }
    
    private void bankSelectAccount(Player player, String name){
    	//check if a bank is selected and check selected bank for the requested account
    }
    
    private void shop(String[] args){
    	
    }
    
    private void economy(String[] args){
    	
    }
    
    public static Player getPlayerObject(String playerName){
    	return Bukkit.getServer().getPlayer(playerName);
    }
}
