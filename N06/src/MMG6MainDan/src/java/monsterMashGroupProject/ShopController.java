/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.Monster;
import databaseManagement.MyUser;
import databaseManagement.PersistManager;
import java.util.List;

/**
 * Contains methods relating to the control of the 
 * system's monster shop.
 * @author jamesslater
 */
public class ShopController {

    private PersistManager pesMan = new PersistManager();
    private Monster monster;
    private MyUser user;
    /**
     * gets x number of monsters from the shop list.
     * @param x
     * @return Monster list of monsters.
     */
    public Monster getShopMonsters(int x) {

        pesMan.init();

        List<Monster> mon = pesMan.searchMonsters("");

        return mon.get(x);
    }
    /**
     * gets the amount of items in the shop.
     * @return int amount of items
     */
    public int getNumOfItems() {
        pesMan.init();

        List<Monster> mon = pesMan.searchMonsters("");

        //pesMan.shutdown();

        return mon.size();
    }
    /**
     * initiates a monster purchase.
     * @param monsterID
     * @param usr
     * @return 
     */
    public String buyMonster(String monsterID, String usr) {

        Shop shp = new Shop();

        pesMan.init();

        List<Monster> mon = pesMan.searchMonsters("");

        for (int i = 0; i < mon.size(); i++) {
            if (mon.get(i).getId() == Integer.parseInt(monsterID)) {
                monster = mon.get(i);
            }
        }


        List<MyUser> users = pesMan.searchUsers();
        for (int i = 0; i < users.size(); i++) {
            if ((users.get(i).getUsername().equals(usr))) {
                user = users.get(i);
            }
        }
        
        shp.BuyMonster(monster, user);

        //pesMan.shutdown();
        return "shop_buy.jsp";
    }
        /**
     * Initiates the sale of a monster.
     * @param monsterID
     * @param usr
     * @return String page to redirect to.
     */
    public String sellMonster(String monsterID){
        
        Shop shp = new Shop();

        pesMan.init();
        
        List<Monster> mon = pesMan.searchMonsters("");

        for (int i = 0; i < mon.size(); i++) {
            if (mon.get(i).getId() == Integer.parseInt(monsterID)) {
                monster = mon.get(i);
            }
        }
        shp.SellMonster(monster);
        
        pesMan.shutdown();
        
        return "shop_sell.jsp";
    }
}
