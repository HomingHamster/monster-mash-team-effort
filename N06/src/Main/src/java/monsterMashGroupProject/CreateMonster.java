/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;
import databaseManagement.*;

/**
 * Class contains methods related to creating a new
 * monster.
 * @author dam44
 */
public class CreateMonster {
    private Monster newMonster;
    private Worth worth = new Worth();
    private String name = new String();
    private PersistManager persistIt = new PersistManager();
    /**
     * Constructor takes a user and a monster name,
     * then randomly creates the first monster for the
     * user.
     * @param user
     * @param monsterName 
     */
    public CreateMonster(MyUser user, String monsterName) {
        persistIt.init();
        Monster monster = MonsterFactory.makeIt(monsterName, 100, 100, 100, 100, user.getUsername());
        persistIt.create(monster);
        persistIt.shutdown();
        worth.UpdateMonsterWorth(monster);
    }
}
