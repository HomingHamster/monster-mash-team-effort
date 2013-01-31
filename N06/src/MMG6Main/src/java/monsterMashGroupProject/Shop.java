/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.*;
import java.util.List;

/**
 * Contains methods relating to the shop.
 * @author dam44
 */
public class Shop {

    PersistManager persistIt = new PersistManager();

    /**
     * Allows a user to buy a selected monster.
     * @param monster
     * @param user 
     */
    public void BuyMonster(Monster monster, 
            MyUser user) {
        persistIt.init();
        List<Monster> monsters = persistIt
                .searchShopMonsters();
        boolean found = false;

        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).getId() == monster
                    .getId()) {
                found = true;
            }
        }
        if (found == true) {
            monster.setOwner(user.getUsername());
            persistIt.update(monster);
            user.setVirtualMoney((
                    user.getVirtualMoney()
                    -monster.getWorth()));
            persistIt.update(user);
        } else {
            System.out.println("Error");
        }
        persistIt.shutdown();
    }
    
    /**
     * allows a user to list a monster in the shop to 
     * be sold.
     * @param monster
     * @param user 
     */
    public void SellMonster(Monster monster,
            MyUser user) {
        persistIt.init();
        List<Monster> monsters = persistIt
                .searchMonsters();
        boolean found = false;

        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).getId() 
                    == monster.getId()) {
                found = true;
            }
        }
        if (found == true) {
            monster.setOwner("");
            persistIt.update(monster);
            //user.setVirtualMoney((
                    //user.getVirtualMoney()+monster
                    //.getWorth()));
            //persistIt.update(user);
        }
        else {
            System.out.println("Error");
        }
        persistIt.shutdown();
    }
}
