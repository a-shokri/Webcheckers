/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webcheckers.data;

import java.sql.SQLException;

/**
 *
 * @author bm3302
 */
public interface IRegLogin {
    public String Login(String playerId, String password)throws SQLException;
    public boolean Register(String email, String password, String playerId)throws SQLException;
}
