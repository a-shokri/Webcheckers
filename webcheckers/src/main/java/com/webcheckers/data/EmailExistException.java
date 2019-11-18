/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webcheckers.data;

/**
 *
 * @author bm3302
 */
public class EmailExistException extends Exception{
    public EmailExistException()
    {
        super("This email is already registered");
    }
}
