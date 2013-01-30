/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import monsterMashGroupProject.*;

/**
 *
 * @author Dan
 */
public class MonsterMash {

    Fight fight = new Fight();
    Breed breed = new Breed();

    /**
     * @param args the command line arguments
     */
    

    /*public MonsterMash() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        PersistManager persistIt = new PersistManager();
        User user = UserFactory.makeIt("Dan21", "hi", 0);
        Monster monster1 = MonsterFactory.makeIt("Gary", 2000, 2000, 2000, 2000, user.getName());
        Monster monster2 = MonsterFactory.makeIt("Fred", 2000, 2000, 2000, 2000, user.getName());
        Monster monster3 = MonsterFactory.makeIt("Bob", 2000, 2000, 2000, 2000, "");
        Monster newMonster = breed.breedMonsters(monster1, monster2, "Dreamings", "Dan8");
        Monster monsterChild = fight.determineWinner(monster1, monster2);
        System.out.println(newMonster.getName() + " " + newMonster.getMaxAge() + " " + newMonster.getAggression() + " " + newMonster.getHeight() + " " + newMonster.getStrength() + " " + user.getName());

        try {
            persistIt.init();
            for (int i = 0; i < persistIt.searchUsers().size(); i++) {
                persistIt.remove(persistIt.searchUsers().get(i));
            }
            for (int i = 0; i < persistIt.searchMonsters().size(); i++) {
                persistIt.remove(persistIt.searchMonsters().get(i));
            }
            persistIt.create(monster1);
            persistIt.create(monster2);
            persistIt.create(monster3);
            persistIt.create(user);
            for (User u : persistIt.searchUsers()) {
                System.out.println(u.getName());
            }
            for (Monster m : persistIt.searchMonsters()) {
                System.out.println(m.getName());
            }

        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } finally {
            persistIt.shutdown();
        }
    }*/
}
