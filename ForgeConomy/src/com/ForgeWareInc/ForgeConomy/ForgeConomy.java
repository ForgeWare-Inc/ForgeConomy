package com.ForgeWareInc.ForgeConomy;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ForgeConomy extends JavaPlugin implements Listener{
	
	ArrayList<Bank> banks = new ArrayList<Bank>();
	HashMap<String, String> userSelectedBank = new HashMap<String, String>();
	
	double pluginVersion = 1.0;
	
	@Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this);
    	getLogger().info("[WELCOME] ForgeConomy " + pluginVersion + " enabled!");
    }
 
    @Override
    public void onDisable() {
        getLogger().info("[BYE] ForgeConomy " + pluginVersion + " disabled!");
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
        		case "bank" : bank(args, player);
        		case "shop" : shop(args);
        		case "econ" : economy(args);
        		case "economy" : economy(args);
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
    
    private void shop(String[] args){
    	
    }
    
    private void economy(String[] args){
    	
    }
}
