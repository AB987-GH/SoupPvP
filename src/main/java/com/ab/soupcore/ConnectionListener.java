package com.ab.soupcore;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.SQLException;

public class ConnectionListener implements Listener {
    private Soupcore main;

    public ConnectionListener(Soupcore main) {
        this.main = main;

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        try {
            SoupPlayer playerData = new SoupPlayer(main, player.getUniqueId());
            main.getPlayerManager().addSoupPlayer(player.getUniqueId(), playerData);
        } catch (SQLException ex) {
            player.kickPlayer("Your data could not be loaded!");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        main.getPlayerManager().removeSoupPlayer(e.getPlayer().getUniqueId());

    }
}
