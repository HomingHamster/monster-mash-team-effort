/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Dan
 */
public class PersistManager {

    private EntityManager managerMonster;
    private EntityManagerFactory factoryMonster;
    private EntityManager managerUser;
    private EntityManagerFactory factoryUser;
    private List<Monster> monsterList;
    private List<User> userList;

    /**
     * Sets up the persistence manager.
     */
    public void init() {
        factoryMonster = Persistence.createEntityManagerFactory("monsters");
        managerMonster = factoryMonster.createEntityManager();
        factoryUser = Persistence.createEntityManagerFactory("users");
        managerUser = factoryUser.createEntityManager();
    }

    /**
     * Adds a monster to the database.
     *
     * @param monster A monster object must be passed in, this is what is added
     * to the database.
     */
    public void create(Monster monster) {
        EntityTransaction tx = managerMonster.getTransaction();
        tx.begin();
        try {
            managerMonster.persist(monster);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        }
        System.out.println(monster.getName() + " has been created.");
    }

    /**
     * Adds a user to the database.
     *
     * @param user A user object must be passed in, this is what is added to the
     * database.
     */
    public void create(User user) {
        EntityTransaction tx = managerUser.getTransaction();
        tx.begin();
        try {
            managerUser.persist(user);
            tx.commit();
        } catch (Exception ex) {
            try {
                tx.rollback();
            } catch (IllegalStateException iSE) {
                System.out.println("!!!!!!!!!!!!YOU TRIED TO ADD A USER WITH THE SAME NAME TWICE, CHANGE IT PLEASE, THEN IT WILL WORK!!!!!!!!!!!!!! \n"
                        + "(The username is the primary key, so no two users with identical names can be created.)");
            }
        }
        System.out.println(user.getName() + " has been created.");
    }

    /**
     * Updates a user by finding the user in the database and then setting that
     * user to the passed in user objects details.
     *
     * @param user
     * @return
     */
    public boolean update(User user) {
        EntityTransaction tx = managerUser.getTransaction();
        tx.begin();
        try {
            User theUser = managerUser.find(User.class, user.getName());
            theUser.setPassword(user.getPassword());
            theUser.setVirtualMoney(user.getVirtualMoney());
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            return false;
        }
    }

    /**
     * Updates a monster by finding the monster in the database and then setting
     * that monster to the passed in monster objects details.
     *
     * @param monster
     * @return
     */
    public boolean update(Monster monster) {
        EntityTransaction tx = managerMonster.getTransaction();
        tx.begin();
        try {
            Monster theMonster = managerMonster.find(Monster.class, monster.getId());
            theMonster.setName(monster.getName());
            theMonster.setHeight(monster.getHeight());
            theMonster.setAge(monster.getAge());
            theMonster.setAggression(monster.getAggression());
            theMonster.setStrength(monster.getStrength());
            theMonster.setOwner(monster.getOwner());
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            return false;
        }
    }

    /**
     * Removes a user by using the user object passed to it to find it in the
     * database.
     *
     * @param user
     * @return
     */
    public boolean remove(User user) {
        EntityTransaction tx = managerUser.getTransaction();
        tx.begin();
        try {
            User theUser = managerUser.find(User.class, user.getName());
            managerUser.remove(theUser);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            return false;
        }
    }

    /**
     * Removes a monster by using the monster object passed to it to find it in
     * the database.
     *
     * @param user
     * @return
     */
    public boolean remove(Monster monster) {
        EntityTransaction tx = managerMonster.getTransaction();
        tx.begin();
        try {
            Monster theMonster = managerMonster.find(Monster.class, monster.getId());
            managerMonster.remove(theMonster);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            return false;
        }
    }

    /**
     * Returns list of Monsters owned by the passed user.
     *
     * @param username
     * @return
     */
    public List<Monster> search(String username) {
        EntityTransaction tx = managerMonster.getTransaction();
        tx.begin();
        Query query = managerMonster.createQuery("select m from Monster m where m.owner='" + username + "'");
        tx.commit();
        monsterList = (List<Monster>) query.getResultList();
        return monsterList;
    }

    /**
     * Returns list of all users. This will likely become to user list so users
     * can interact with each other. May change the method slightly to take in
     * SQL(String) statements as a parameter to make it more dynamic.
     *
     * @param username
     * @return
     */
    public List<User> search() {
        EntityTransaction tx = managerUser.getTransaction();
        tx.begin();
        Query query = managerUser.createQuery("select u from User u");
        tx.commit();
        userList = (List<User>) query.getResultList();
        return userList;
    }

    /**
     * Closes the applications interaction with the databases.
     */
    public void shutdown() {
        managerMonster.close();
        factoryMonster.close();
        managerUser.close();
        factoryUser.close();
    }
}
