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
 *
 * @author jamesslater
 */
public class UserController {

    MyUser theUsr;
    MyUser frind;
    int choice1;
    int choice2;
    String childName;
    String friendusername;
    Monster childMon = null;
    PersistManager pesMan = new PersistManager();

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

    public MyUser getTheUsr() {
        return theUsr;
    }

    public String setTheUsr(Login log) {
        this.theUsr = log.user;
        return "";
    }

    public String logOut(){
        
        theUsr = null;
        
        Login log = new Login();
        
        log.LogOff();
        
        return "index.jsp";
    }
    
    public Monster getMonster(int num) {

        pesMan.init();

        List<Monster> mon = pesMan.searchMonsters(theUsr.getUsername());



        return mon.get(num);

    }

    public String bread() {

        Breed breed = new Breed();

        pesMan.init();

        List<Monster> mon = pesMan.searchMonsters(theUsr.getUsername());

        childMon = breed.breedMonsters(mon.get(choice1), mon.get(choice2), childName, theUsr.getUsername());


        return "farm.jsp";
    }

    public int getNumOfMonsters() {

        pesMan.init();

        List<Monster> mon = pesMan.searchMonsters(theUsr.getUsername());

        return mon.size();
    }

    public String sellMonster(int x) {


        return "";
    }

    public int getMoney() {
        return theUsr.getVirtualMoney();
    }

    public int getNumOfFriends() {
        return theUsr.getFriends().size();
    }

    public String addFriend() {

        FriendsList frd = new FriendsList();

        pesMan.init();

        List<MyUser> ppl = pesMan.searchUsers();

        for (int i = 0; i < ppl.size(); i++) {
            if(ppl.get(i).getUsername().equals(friendusername)){
                frd.addFriend(theUsr, ppl.get(i));
            }
        }

        return "welcome.jsp";
    }
    
    public String getPicSrc(String monName){
        
        String temp = "http://bbrks.me/221/monsterid.php?seed="+ monName;
        
        return temp;
    }
}
