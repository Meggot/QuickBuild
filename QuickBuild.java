package me.meggot.QuickBuild;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import me.meggot.QuickBuild.Commands.challengeCommand;
import me.meggot.QuickBuild.Commands.startCommand;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class QuickBuild extends JavaPlugin {
    public void onDisable() {
    }

    public void onEnable() {
        PluginDescriptionFile desc = getDescription();
        System.out.println(desc.getFullName() + " has been enabled");
        getCommand("challenge").setExecutor(new challengeCommand(this));
        getCommand("start").setExecutor(new startCommand(this));
        setupDatabase();
    }

    private void setupDatabase() {
        try {
            getDatabase().find(Duel.class).findRowCount();
        } catch (PersistenceException ex) {
            System.out.println("Installing database for " + getDescription().getName() + " due to first time usage");
            installDDL();
        }
    }

    @Override
    public List<Class<?>> getDatabaseClasses() {
        List<Class<?>> list = new ArrayList<Class<?>>();
        list.add(Duel.class);
        return list;
    }

    public static boolean anonymousCheck(CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Cannot execute that command, I don't know who you are!");
            return true;
        } else {
            return false;
        }
    }
}
