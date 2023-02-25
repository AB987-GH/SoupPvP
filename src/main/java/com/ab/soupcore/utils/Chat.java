package com.ab.soupcore.utils;

import org.bukkit.ChatColor;

public class Chat {

    // basic method used to save time when formatting chat messages

    public static String format (String string){
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
