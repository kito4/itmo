package kito.lab5.server;

import java.sql.*;

public class PgManager {
    private Connection conn;

    public PgManager() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://pg:5432/studs");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getSet(String request) {
        try {
            return conn.prepareStatement(request).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;            // TODO 2209 correct return?
        }
    }

    public void doCommand(String request) {
        try {
            conn.prepareStatement(request).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
