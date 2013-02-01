/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduling;

import databaseManagement.Monster;
import databaseManagement.MyUser;
import databaseManagement.PersistManager;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A class to contain the logic that ages a monster.
 * @author dam44
 */
public class MonsterLifeCycle {

    private Timer timer;
    /**
     * Runs task on the selected user every x seconds.
     * @param seconds
     * @param user 
     */
    public MonsterLifeCycle(int seconds, MyUser user) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new Task(user), seconds * 1000, seconds * 1000);
    }
    /**
     * Class extends TimerTask to contain the logic
     * that ages all of a user's monsters.
     */
    class Task extends TimerTask {

        MyUser user;

        public Task(MyUser user) {
            this.user = user;
        }
        /**
         * Method contains the logic to age a monster. Time between aging alterable. New thread
         * is started for user when they login that ages all their monsters. When the age of the monster
         * reaches the monsters max age the monster is removed.
         */
        @Override
        public void run() {
            PersistManager persistIt = new PersistManager();
            persistIt.init();
            List<MyUser> users = persistIt.searchUsers();
            for (int i = 0; i < users.size(); i++) {
                if ((users.get(i).getUsername().equals(user.getUsername())) && (users.get(i).getUserPassword().equals(user.getUsername()))) {
                    user = users.get(i);
                }
            }
            if (user.isIsLoggedIn() == true) {
                List<Monster> monsters = persistIt.searchMonsters(user.getUsername());
                for (int i = 0; i < monsters.size(); i++) {
                    if (monsters.get(i).isIsImmortal() == false) {
                        if ((monsters.get(i).getAge() > monsters.get(i).getMaxAge()) || (monsters.get(i).getAge() == monsters.get(i).getMaxAge())) {
                            monsters.get(i).setIsDead(true);
                            persistIt.remove(monsters.get(i));
                            timer.cancel();

                        } else {
                            int currentAge = monsters.get(i).getAge();
                            monsters.get(i).setAge(currentAge + 1);
                            persistIt.getUpdatedMonster(user, monsters.get(i));
                            persistIt.getUpdatedUser(user);
                            System.out.println(monsters.get(i).getAge() + " " + monsters.get(i).getName());
                        }
                    }
                }
            } else {
                timer.cancel();
            }
            persistIt.shutdown();
        }
    }
}