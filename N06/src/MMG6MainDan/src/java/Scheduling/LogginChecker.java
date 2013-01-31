/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduling;

/**
 * This class checks to see if a user is still active
 * and logged on.
 * @author dam44
 */
import java.util.Timer;
import java.util.TimerTask;
import databaseManagement.*;
import java.util.List;
import monsterMashGroupProject.Login;

public class LogginChecker {

    private Timer timer;
    /**
     * Runs Task on a user every x seconds.
     * @param seconds
     * @param user 
     */
    public LogginChecker(int seconds, MyUser user) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new Task(user), seconds * 1000, seconds * 1000);
    }
   /**
     * Class extends TimerTask. Checks if user is still
     * logged into the website.
     */
    class Task extends TimerTask {

        MyUser user;

        public Task(MyUser user) {
            this.user = user;
        }
        /**
         * logic to set a user as logged out if they
         * are inactive.
         */
        @Override
        public void run() {
            PersistManager persistIt = new PersistManager();
            persistIt.init();
            List<MyUser> users = persistIt.searchUsers();
            for (int i = 0; i < users.size(); i++) {
                if ((users.get(i).getUsername().equals(user.getUsername())) && (users.get(i).getUserPassword().equals(user.getUsername()))) {
                    user = users.get(i);
                    if (user.isIsActive() == false) {
                        user.setIsLoggedIn(false);
                        persistIt.update(user);
                        timer.cancel();
                        Login login = new Login();
                        login.LogOff();
                    } else {
                        user.setIsActive(false);
                    }
                }
            }
            persistIt.shutdown();
        }
    }
}
