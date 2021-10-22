package model;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static Database instance = null;
    private static Connection connection = null;
    
    private Database() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/v22_database", "sa", "sa");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.CreateTables();
    }
    
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        } 
        return instance;
    }
    
    public ResultSet Query(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }
    
    public int Update(String sql) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    private void CreateTables() {
       try {
            URL url = getClass().getResource("testing.sql");
            FileInputStream fstream = new FileInputStream(url.getPath());
            try (DataInputStream in = new DataInputStream(fstream)) {
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String sqlLine;
                while ((sqlLine = br.readLine()) != null)   {
                        Update(sqlLine);
                }
            }
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }        
     }
}