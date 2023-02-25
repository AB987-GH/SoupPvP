package com.ab.soupcore.listeners;

import com.ab.soupcore.PlayerManager;
import com.ab.soupcore.Soupcore;
import com.ab.soupcore.utils.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import com.ab.soupcore.SoupPlayer;



public class KillDeathListener extends JavaPlugin implements Listener {
    private Soupcore main;

    private SoupPlayer soupPlayer;

    private PlayerManager playerManager;


    @EventHandler
    public void onEvent(PlayerDeathEvent e){

            // updating stats of player who died
            Player player = e.getEntity().getPlayer();
            Player killer = e.getEntity().getKiller();
            SoupPlayer soupPlayer1 = playerManager.getSoupPlayer(player.getUniqueId());

            int curDeaths = soupPlayer1.getDeaths();
            int curKs = soupPlayer1.getKs();
            int curBestKs = soupPlayer1.getBestKs();
            soupPlayer1.setDeaths(curDeaths++);
            if (curKs > curBestKs){
                soupPlayer1.setBestKs(curKs);
            }
            soupPlayer1.setKs(0);

            // updating stats of player who got the kill
            if (killer instanceof Player){
                SoupPlayer soupPlayer2 = playerManager.getSoupPlayer(killer.getUniqueId());
                int curKills = soupPlayer2.getKills();
                curKs = soupPlayer2.getKs();
                curBestKs = soupPlayer2.getBestKs();
                soupPlayer2.setKills(curKills++);
                soupPlayer2.setKs(curKs++);
                curKs = soupPlayer2.getKs();
                if (curKs > curBestKs){
                    soupPlayer2.setBestKs(curKs);
                    killer.sendMessage(Chat.format("&eYou recieved &a$10 &eand &610 XP &efor killing " + player.getPlayer()));
                }


            }
    }

}
