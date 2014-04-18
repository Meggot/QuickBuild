package me.meggot.QuickBuild;

import me.meggot.QuickBuild.QuickBuild;
import me.meggot.QuickBuild.Duel;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class challengeCommand implements CommandExecutor {
	
    private final QuickBuild plugin;
    
    public challengeCommand(QuickBuild plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        	if (args.length >= 2)
        	{
        		// /challenge [playerName] [challengeName] [typeOfBuild]
        		if (!(sender instanceof Player)) {
        			sender.sendMessage("This command can only be run by Players.");
        			return false;
        		} else {
        		@SuppressWarnings("deprecation")
				Player opponent = (Bukkit.getServer().getPlayer(args[0]));
        	    if (opponent == null) {
        	    sender.sendMessage(args[0] + " is not online!");
        	    return false;
        	    } else {
        			Player challenger = (Player) sender;
        			String challengerName = challenger.getName();
        			opponent.sendMessage(ChatColor.AQUA + challengerName + " has challenged you to a Build Duel, type: " + args[1]);
        			String opponentName = args[0];
            		String typeOfBuild = args[2];
            		//Finally the Challenge is made.
            		Duel duel = new Duel();
            		duel.setChallengerName(challengerName);
            		duel.setOpponentName(opponentName);
            		duel.setTypeName(typeOfBuild);
            		duel.setChallengeName(args[1]);
            		plugin.getDatabase().save(duel);
            		sender.sendMessage(ChatColor.AQUA + "You have challenged " + opponentName + " to a quickbuild duel with the type: " + args[1]);
            		return false;
        		}
        		}
        	} else
        		return true;
    }
}
