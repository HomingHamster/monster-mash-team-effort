/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;
import databaseManagement.*;


public class CreateMonster {
    private Monster newMonster;
    private Worth worth = new Worth();
    private String name = new String();
    private PersistManager persistIt = new PersistManager();
    public CreateMonster(MyUser user, String monsterName) {
        persistIt.init();
        Monster monster = MonsterFactory.makeIt(monsterName, 100, 100, 100, 100, user.getUsername());
        persistIt.create(monster);
        persistIt.shutdown();
        worth.UpdateMonsterWorth(monster);
    }
}
