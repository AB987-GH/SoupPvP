package com.ab.soupcore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private final String HOST = Soupcore.getMainInstance().getConfig().getString("host");

    private final String PORT = Soupcore.getMainInstance().getConfig().getString("port");

    private final String DATABASE = Soupcore.getMainInstance().getConfig().getString("database");

    private final String USERNAME = Soupcore.getMainInstance().getConfig().getString("username");

    private final String PASSWORD = Soupcore.getMainInstance().getConfig().getString("password");

    private Connection connection;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false",
                USERNAME,
                PASSWORD);
    }

    public void makeTable(){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS stats (ID char(36), KILLS int, DEATHS int, KS int, BESTKS int, LEVEL int, PRESTIGE int, CURRENTXP int, TOTALXP int);");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        return connection != null;
    }

    public Connection getConnection() { return connection; }

    public void disconnect() {
        if (isConnected()){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
