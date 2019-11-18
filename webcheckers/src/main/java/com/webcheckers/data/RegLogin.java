/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webcheckers.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.util.UUID;
/**
 *
 * @author bm3302
 */

public class RegLogin implements IRegLogin{
    private String databaseURL = "";
    private Connection connection = null;
    
    public RegLogin(String databasePath) throws SQLException
    {
        this.databaseURL = databasePath;
        this.connection= DriverManager.getConnection(this.databaseURL, "root", "110110");
    }
    @Override
    public String Login(String playerId, String password) throws SQLException
    {
        if (checkUserRegistered(playerId, password))
        {
            String uniqueID = UUID.randomUUID().toString();
            return uniqueID.replaceAll("-", "");
        }
        return "";
    }
    
    @Override
    public boolean Register(String email, String password, String playerId) throws SQLException
    {
        if(this.isValidEmail(email)==false)
            return false;
        if(this.checkUserExists(email,playerId)==true)
            return false;
        this.saveToDatabase(email, password, playerId);
        return true;
    }
    
    private boolean isValidEmail(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 

    private boolean checkUserExists(String email, String playerId) throws SQLException {
        String sql_res= "select * from Player where email='".concat(email).concat("';");
        Statement stmt=(Statement)this.connection.createStatement();
        if(stmt.executeQuery(sql_res).next()==true)
            return true;
        sql_res= "select * from Player where playerId='".concat(playerId).concat("';");
        stmt=(Statement)this.connection.createStatement();
        if(stmt.executeQuery(sql_res).next()==true)
            return true;
        return false;
    }
    
    private boolean checkUserRegistered(String playerId, String password) throws SQLException {
        String sql_res= "select * from Player where playerId='".concat(playerId).concat("' and password='").concat(password).concat("';");
        Statement stmt=(Statement)this.connection.createStatement();
        if(stmt.executeQuery(sql_res).next()==true)
            return true;
        return false;
    }
    
    private void saveToDatabase(String email, String password, String playerId) throws SQLException {
        Statement stmt=(Statement)this.connection.createStatement();
        String insert="INSERT INTO Player VALUES('"+playerId+"','"+email+ "','"+ password+"');";
        stmt.executeUpdate(insert);
    }
}
