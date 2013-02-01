/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.Monster;
import databaseManagement.MyUser;
import databaseManagement.PersistManager;
import databaseManagement.Requests;
import java.util.List;

/**
 * Contains classes that relate to the control of user accounts.
 *
 * @author jamesslater
 */
public class UserController {

    private MyUser theUsr;
    private int choice1;
    private int choice2;
    private String childName;
    private Monster childMon = null;
    PersistManager pesMan = new PersistManager();
    private Monster winner;

    public int getChoice1() {
        return choice1;
    }

    public void setChoice1(int choice1) {
        this.choice1 = choice1;
    }

    public int getChoice2() {
        return choice2;
    }

    public void setChoice2(int choice2) {
        this.choice2 = choice2;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Monster getChildMon() {


        return childMon;
    }

    public void setChildMon(Monster childMon) {
        this.childMon = childMon;
    }

    /**
     * gets the current user.
     *
     * @return MyUser user.
     */
    public MyUser getTheUsr() {
        return theUsr;
    }

    /**
     * sets the current user.
     *
     * @param log
     * @return String blank for compatability.
     */
    public String setTheUsr(Login log) {
        this.theUsr = log.user;
        return "";
    }

    /**
     * Gets a users monster by index number.
     *
     * @param num
     * @return Monster monster.
     */
    public Monster getMonster(int num) {

        pesMan.init();

        List<Monster> mon = pesMan.searchMonsters(theUsr.getUsername());



        return mon.get(num);
        //TODO: spelling mistake maybe?
        /**
         * Puts a monster in breadcrumbs ready for serving.
         *
         * @return BreadcrumbMonster a breaded monster.
         */
    }

    public String bread() {

        Breed breed = new Breed();

        pesMan.init();

        List<Monster> mon = pesMan.searchMonsters(theUsr.getUsername());

        childMon = breed.breedMonsters(mon.get(choice1), mon.get(choice2), childName, theUsr.getUsername(), true);


        return "farm.jsp";
    }

    /**
     * gets the number of monster a user has.
     *
     * @return int number of monsters.
     */
    public int getNumOfMonsters() {

        pesMan.init();

        List<Monster> mon = pesMan.searchMonsters(theUsr.getUsername());

        return mon.size();
    }

    /**
     * gets the amount of money a user has.
     *
     * @return int amount of money.
     */
    public int getMoney() {
        return theUsr.getVirtualMoney();
    }

    /**
     * gets the number of friends a user has.
     *
     * @return int number of friends.
     */
    public int getNumOfFriends() {
        return 5;
    }

    /**
     * gets a link to the user's monster's picture
     *
     * @param monName
     * @returßßn String address to picture.
     */
    public String getPicSrc(String monName) {
        String temp = "http://bbrks.me/221/monsterid.php?seed=" + monName;
        return temp;
    }

    public Requests getRequest(int i) {

        pesMan.init();

        List<Requests> requests = pesMan.searchRequets(theUsr.getUsername());


        return requests.get(i);
    }

    public int getSizeOfRequests() {

        pesMan.init();

        List<Requests> requests = pesMan.searchRequets(theUsr.getUsername());

        return requests.size();

    }
    
    public String fight(){
        
        Fight fight = new Fight();
        
        pesMan.init();

        List<Monster> mon = pesMan.searchMonsters(theUsr.getUsername());

        winner = fight.determineWinner(mon.get(choice1), mon.get(choice2));
        
        return "Outcome.jsp";
    }
    
    public Monster getWinner(){
        return winner;
    }
}
