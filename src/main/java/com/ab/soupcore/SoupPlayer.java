package com.ab.soupcore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SoupPlayer {
    // local variables that will always reflect what is in the database
    private UUID uuid;
    private int kills;
    private int deaths;
    private int kd;

    private int ks;
    private int bestKs;
    private int level;
    private int prestige;
    private int currentXp;
    private int totalXp;

    private Soupcore main;

    public SoupPlayer(Soupcore main, UUID uuid) throws SQLException {
        this.main = main;

        this.uuid = uuid;

            PreparedStatement statement = main.getDatabase().getConnection().prepareStatement("SELECT KILLS, DEATHS, KS BESTKS, LEVEL, PRESTIGE, CURRENTXP, TOTALXP FROM stats WHERE UUID = ?;");
            statement.setString(1, uuid.toString());
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            // if player is in database, update stats
            if (rs.next()) {
                kills = rs.getInt("KILLS");
                deaths = rs.getInt("DEATHS");
                kd = kills / deaths;
                ks = rs.getInt("KS");
                bestKs = rs.getInt("BESTKS");
                level = rs.getInt("LEVEL");
                prestige = rs.getInt("PRESTIGE");
                currentXp = rs.getInt("CURRENTXP");
                totalXp = rs.getInt("TOTALXP");
                // otherwise, set default stat values
            } else {
                kills = 0;
                deaths = 0;
                ks = 0;
                bestKs = 0;
                level = 1;
                prestige = 0;
                currentXp = 0;
                totalXp = 0;
                PreparedStatement statement1 = main.getDatabase().getConnection().prepareStatement("INSERT INTO stats (ID, KILLS, DEATHS, KS, BESTKS, LEVEL, PRESTIGE, CURRENTXP, TOTALXP) VALUES (" +
                        "'" + uuid + "'," +
                        kills +
                        deaths +
                        bestKs +
                        level +
                        prestige +
                        currentXp +
                        totalXp + ");");
                statement.executeUpdate();

            }

    }

    public SoupPlayer() {

    }

    // get methods; will return the local variable of the given stat (which reflects the db)
    public int getKills() { return kills; }
    public int getDeaths() { return deaths; }
    public int getKs() { return ks; }
    public int getBestKs() { return bestKs; }
    public int getLevel() { return level; }
    public int getPrestige() { return prestige; }
    public int getCurrentXp() { return currentXp; }
    public int getTotalXp() { return totalXp; }


    // set methods; used for updating both the database and the local variables
    public void setKills(int kills) {
        this.kills = kills;
        try {
        PreparedStatement statement = main.getDatabase().getConnection().prepareStatement("UPDATE stats SET KILLS = " + kills + " WHERE ID = '" + uuid + "';");
        statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
        try {
            PreparedStatement statement = main.getDatabase().getConnection().prepareStatement("UPDATE stats SET DEATHS = " + deaths + " WHERE ID = '" + uuid + "';");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBestKs(int bestKs) {
        this.bestKs = bestKs;
        try {
            PreparedStatement statement = main.getDatabase().getConnection().prepareStatement("UPDATE stats SET BESTKS = " + bestKs + " WHERE ID = '" + uuid + "';");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void setLevel(int level) {
        this.level = level;
        try {
            PreparedStatement statement = main.getDatabase().getConnection().prepareStatement("UPDATE stats SET LEVEL = " + level + " WHERE ID = '" + uuid + "';");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setKs(int ks) {
        this.ks = ks;
        try {
            PreparedStatement statement = main.getDatabase().getConnection().prepareStatement("UPDATE stats SET KS = " + ks + " WHERE ID = '" + uuid + "';");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
