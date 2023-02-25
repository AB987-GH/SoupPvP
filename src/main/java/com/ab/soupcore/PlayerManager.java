package com.ab.soupcore;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {

    private HashMap<UUID, SoupPlayer> soupPlayers = new HashMap<>();

    public SoupPlayer getSoupPlayer(UUID uuid){
        return soupPlayers.get(uuid);
    }

    public void addSoupPlayer(UUID uuid, SoupPlayer player){
        soupPlayers.put(uuid, player);
    }

    public void removeSoupPlayer(UUID uuid){
        soupPlayers.remove(uuid);
    }
}
