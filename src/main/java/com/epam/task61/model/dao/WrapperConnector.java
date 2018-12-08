package com.epam.task61.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class WrapperConnector {
    protected Connection dbCon;
    Statement stmt;
    ResourceBundle resource =
            ResourceBundle.getBundle("property.database");
    String driver = resource.getString("driver");
    String url = resource.getString("url");
    String user = resource.getString("user");
    String pass = resource.getString("password");

    WrapperConnector() {

        try {
            Class.forName(driver);
            dbCon = DriverManager.getConnection(url, user, pass);
            stmt = dbCon.createStatement();
        } catch (ClassNotFoundException | SQLException e) {

        }
    }


    public void closeConnection() throws SQLException {
        dbCon.close();
    }

    public void closeStatement(Statement statement) throws SQLException {
        stmt.close();
    }

    public boolean getConnectStatus() {
        boolean validConnection = false;
        if (dbCon != null) validConnection = true;

        return validConnection;
    }
}
