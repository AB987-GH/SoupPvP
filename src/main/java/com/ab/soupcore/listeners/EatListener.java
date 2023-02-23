package com.ab.soupcore.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EatListener implements Listener {

    @EventHandler
    public void onEvent(PlayerInteractEvent e){
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            Player player = e.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.getType() == Material.MUSHROOM_SOUP){
                item.setType(Material.BOWL);
                player.setHealth(player.getHealth() + 3.5);
            }
        }
    }
}
