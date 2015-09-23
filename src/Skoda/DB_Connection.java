package Skoda;

import java.sql.*;
import javax.swing.*;

public class DB_Connection {

    Connection conn = null;

    public static Connection ConnectDb() {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:DB\\scodadb.sqlite");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database mungon!");
            return null;

        }

    }
}
