/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.*;

/**
 * Contains methods relating to trade of monsters.
 * @author dam44
 */
public class Trade {
    
    PersistManager persistIt = new PersistManager();
    
    /**
     * Initiates the trade of two given monsters.
     * @param monster1
     * @param monster2 
     */
    public Trade(Monster monster1, Monster monster2) {
        persistIt.init();
        String temp = monster1.getOwner();
        monster1.setOwner(monster2.getOwner());
        monster2.setOwner(temp);
        persistIt.update(monster1);
        persistIt.update(monster2);
        persistIt.shutdown();
    }
}
