package com.ab.soupcore;

import com.ab.soupcore.kits.SelectKitCommand;
import com.ab.soupcore.listeners.EatListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.SQLException;

public final class Soupcore extends JavaPlugin {

    private Database database;
    private PlayerManager playerManager;

    private static Soupcore mainInstance;

    @Override
    public void onEnable() {

        database = new Database();
        playerManager = new PlayerManager();
        try {
            database.connect();
            database.makeTable();

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to connect to MySQL Database, plugin shutting down");
        }

        playerManager = new PlayerManager();

        this.getConfig().options().copyDefaults();
        saveDefaultConfig();

        System.out.println("Soup Core v1.0 was enabled successfully");

        Bukkit.getPluginManager().registerEvents(new EatListener(), this);
        Bukkit.getPluginManager().registerEvents(new ConnectionListener(this), (this));

        getCommand("selectkit").setExecutor(new SelectKitCommand());

    }

    public static Soupcore getMainInstance() {
        return mainInstance;
    }

    @Override
    public void onDisable() {

        database.disconnect();

        System.out.println("Soup Core v1.0 has been disabled");
        // Plugin shutdown logic
    }

    public Database getDatabase() {return database; }
    public PlayerManager getPlayerManager() { return playerManager; }
}
