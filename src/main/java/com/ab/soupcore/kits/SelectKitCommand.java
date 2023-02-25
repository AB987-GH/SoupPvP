package com.ab.soupcore.kits;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class SelectKitCommand extends JavaPlugin implements CommandExecutor {

    private String format (String string){
        return ChatColor.translateAlternateColorCodes('&', string);
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 0){
                player.sendMessage(format("&cUsage: /selectkit &e<kit>"));
            } else {


            }
        } else {
            System.out.println("This command is for players only");
        }
        return false;
    }
}
