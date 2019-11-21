/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webcheckers.model.db;

import com.webcheckers.model.HumanPlayer;
import com.webcheckers.model.Player;
import java.io.File;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

/**
 *
 * @author bm3302
 */
public class test {
    public static void main(String[] args) {

//        String temp = System.getProperty("user.dir")+("/src/main/java/com/webcheckers/model/db/hibernate.cfg.xml");
//        System.out.println(temp);
//        File file = new File(temp);
//        boolean exists = file.exists();
//        System.out.println(exists);
        DBManager db = new  DBManager();
//        HumanPlayer p = new HumanPlayer();
//        p.setEMAIL("tewst@33test.com");
//        p.setPASSWORD("testPass");
//        p.setUSERNAME( "test33User" );
         HumanPlayer p = (HumanPlayer)db.findById(HumanPlayer.class, 4);
         Map<String, Object> test2 = Map.ofEntries(
            entry("ID", 5),
            entry("USERNAME", "testUser")
            );
         
         List<Object> temp = db.find(HumanPlayer.class, test2);
         System.out.println(p.getEMAIL());
//        
//        HumanPlayer p2 = new HumanPlayer();
//        p2.setEMAIL("tewst2@test.com");
//        p2.setPASSWORD("NOOO");
//        p2.setUSERNAME( "test2User" );
//        p2.setID(4);
//        db.save(p);
//        db.delete(p);
//        db.update(p2);

        
    }
}

