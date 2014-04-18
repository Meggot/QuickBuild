package me.meggot.QuickBuild.Commands;

import me.meggot.QuickBuild.QuickBuild;
import me.meggot.QuickBuild.Duel;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class startCommand implements CommandExecutor {
	
    private final QuickBuild plugin;
    
    public startCommand(QuickBuild plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	// Command: /start [challengeName]
    	// This will get all the team members, teleport them to the teamleaders location and
    	// inform them all of the team type and the name of all the builders.
    	if (args.length >= 0)
    	{
    		Duel temp = plugin.getDatabase().find(Duel.class).where().ieq("challengeName", args[0]).findUnique();
    		if (temp == null)
    		{
    			sender.sendMessage(ChatColor.RED + "No duel exists with that name.");
    			return false;
    		} else {
    		Player opponent = temp.getOpponent();
    		Player challenger = temp.getChallenger();
    		Location duelLocation = challenger.getLocation();
    		opponent.sendMessage(ChatColor.AQUA + "The quick build has started! The type is: " + temp.getTypeName());
    		challenger.sendMessage(ChatColor.AQUA + "The quick build has started! The type is: " + temp.getTypeName());
    		opponent.teleport(duelLocation);
    		challenger.teleport(duelLocation);
    		return false;
    		}
    	} else {
    	return true;
    	}
    }
}
