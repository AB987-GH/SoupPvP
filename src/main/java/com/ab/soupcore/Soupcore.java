package com.ab.soupcore;

import com.ab.soupcore.listeners.EatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Soupcore extends JavaPlugin {

    @Override
    public void onEnable() {

        System.out.println("Soup Core v1.0 was enabled successfully");

        Bukkit.getPluginManager().registerEvents(new EatListener(), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {

        System.out.println("Soup core v1.0 was disabled successfully");
        // Plugin shutdown logic
    }
}
