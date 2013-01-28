/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.*;
import java.util.List;

/**
 *
 * @author dam44
 */
public class Shop {

    PersistManager persistIt = new PersistManager();

    public void BuyMonster(Monster monster, User user) {
        persistIt.init();
        List<Monster> monsters = persistIt.searchShopMonsters();
        boolean found = false;

        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).getId() == monster.getId()) {
                found = true;
            }
        }
        if (found == true) {
            monster.setOwner(user.getName());
            persistIt.update(monster);
        } else {
            System.out.println("Error");
        }
        persistIt.shutdown();
    }
    
    public void SellMonster(Monster monster) {
                persistIt.init();
        List<Monster> monsters = persistIt.searchMonsters();
        boolean found = false;

        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).getId() == monster.getId()) {
                found = true;
            }
        }
        if (found == true) {
            monster.setOwner("");
            persistIt.update(monster);
        }
        else {
            System.out.println("Error");
        }
        persistIt.shutdown();
    }
}
