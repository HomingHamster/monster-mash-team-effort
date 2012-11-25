/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import databaseManagement.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author Dan
 */
public class TestPersistance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        /*
         *Starts a connection with the database 
         */
        Class.forName("org.hsqldb.jdbcDriver").newInstance();
        Connection c = DriverManager.getConnection("jdbc:hsqldb:file:monsters", "", "");
        PersistManager persistIt = new PersistManager();

        /*
         * Makes a new user and monster using the MakeUser.makeIt() static method, this is just a shortcut so I don't have to keep writing out setters.
         */
        User user = MakeUser.makeIt("Enzo", "hi", 0);
        Monster monster = MakeMonster.makeIt("Rawr", 100, 1, 100, 100, user.getName());
        try {
            /*
             * Initializes the persistance class and adds the monser and user.
             */
            persistIt.init();
            persistIt.create(monster);
            persistIt.create(user);
            /*
             * loops through both list, fairly obvious, but am putting it anyway hehe.
             */
            for (User u : persistIt.search()) {
                System.out.println(u.getName());
            }
            for (Monster m : persistIt.search(user.getName())) {
                System.out.println(m.getName());
            }

        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } finally {
            persistIt.shutdown();
        }
        /*
         * Closes the database.
         */
        Statement stmt = c.createStatement();
        stmt.execute("SHUTDOWN");
        c.close();
    }
}
