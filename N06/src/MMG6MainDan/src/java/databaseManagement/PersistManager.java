/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Contains the methods that relate to 
 * maintaining persistence in the application.
 * @author Dan
 */
public class PersistManager {

    private EntityManager manager;
    private EntityManagerFactory factory;
    private List<Monster> monsterList;
    private List<Monster> userMonsters;
    private List<MyUser> userList;
    private List<Monster> shopList;
    /**
     * Creates a monster in persistence and 
     * puts it in the database.
     * @param monster 
     */
    public void create(Monster monster) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            manager.persist(monster);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        }
        System.out.println(monster.getName() + " has been created.");
    }
    /**
     * Creates a user in persistence and puts 
     * it in the database.
     * @param user 
     */
    public void create(MyUser user) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            manager.persist(user);
            //System.out.println(user.getName() +" "+ user.getPassword() +" "+ user.isLoggedIn() +" "+ user.getVirtualMoney());
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        }
        System.out.println(user.getUsername() + " has been created.");
    }
    /**
     * Updates a user in persistence and replaces
     * it in the database.
     * @param user
     * @return 
     */
    public boolean update(MyUser user) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            MyUser theUser = manager.find(MyUser.class, user.getUsername());
            theUser.setUserPassword(user.getUserPassword());
            theUser.setVirtualMoney(user.getVirtualMoney());
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            return false;
        }
    }
    /**
     * Updates a user in persistence and 
     * replaces it in the database.
     * @param monster
     * @return 
     */
    public boolean update(Monster monster) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            Monster theMonster = manager.find(Monster.class, monster.getId());
            theMonster.setName(monster.getName());
            theMonster.setHeight(monster.getHeight());
            theMonster.setAge(monster.getAge());
            theMonster.setMaxAge(monster.getMaxAge());
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
     * Removes a user from the database.
     * @param user
     * @return bool success.
     */
    public boolean remove(MyUser user) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            MyUser theUser = manager.find(MyUser.class, user.getUsername());
            List<Monster> temp = searchMonsters(theUser.getUsername());
            for (int i = 0; i < temp.size(); i++) {
                manager.remove(temp.get(i));
            }
            manager.remove(theUser);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            return false;
        }
    }
    /**
     * removes a monster from the database.
     * @param monster
     * @return 
     */
    public boolean remove(Monster monster) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            Monster theMonster = manager.find(Monster.class, monster.getId());
            manager.remove(theMonster);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            return false;
        }
    }
    /**
     * drops a given table from the database.
     * @param table
     * @return bool success.
     */
    public boolean dropTable(String table) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            Query query = manager.createQuery("DROP TABLE +table");
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            return false;
        }
    }

    /**
     * Gets an updated user given the original.
     * @param username
     * @return MyUser user.
     */
    public MyUser getUpdatedUser(MyUser user) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("SELECT u FROM MyUser u WHERE u.username='" + user.getUsername() + "'");
        tx.commit();
        userList = (List<MyUser>) query.getResultList();
        return userList.get(0);
    }
    /**
     * gets an updated monster given a user and a monster.
     * @param user
     * @param monster
     * @return Monster updated monster.
     */
    public Monster getUpdatedMonster(MyUser user, Monster monster) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("SELECT m FROM Monster m WHERE m.owner='" + user.getUsername() + "' AND m.name='" + monster.getName() + "' ");
        tx.commit();
        monsterList = (List<Monster>) query.getResultList();
        return monsterList.get(0);
    }
    /**
     * returns a list of monsters for a given username.
     * @param username
     * @return List<Monster> monsters.
     */
    public List<Monster> searchMonsters(String username) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select m from Monster m where m.owner='" + username + "'");
        tx.commit();
        userMonsters = (List<Monster>) query.getResultList();
        return userMonsters;
    }
    /**
     * returns a list of monsters for a given username.
     * @param username
     * @return List<Monster> monsters.
     */
    public List<Monster> searchMonsters() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select m from Monster m");
        tx.commit();
        monsterList = (List<Monster>) query.getResultList();
        return monsterList;
    }
    /**
     * searches the the monster graveyard for
     * monsters that used to belong to a given
     * user.
     * @param username
     * @return List<Monster> monsters.
     */
    public List<Monster> searchGraveYard(String username) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("SELECT m FROM Monster m WHERE m.owner='" + username + "' AND m.isDead=1");
        tx.commit();
        userMonsters = (List<Monster>) query.getResultList();
        return userMonsters;
    }
    /**
     * Search users
     * @return List<MyUser> users.
     */
    //TODO: what users does this return, all of them?
    public List<MyUser> searchUsers() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select u from MyUser u");
        tx.commit();
        userList = (List<MyUser>) query.getResultList();
        return userList;
    }
    /**
     * gets a list of monsters that are 
     * currently in the shop.
     * @return List<Monster> monsters.
     */
    public List<Monster> searchShopMonsters() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select m from Monster m where m.owner='" + "'");
        tx.commit();
        shopList = (List<Monster>) query.getResultList();
        return shopList;
    }
    /**
     * initialise the persistence.
     */
    public void init() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            factory = Persistence.createEntityManagerFactory("monsters");
            manager = factory.createEntityManager();
        } catch (InstantiationException ex) {
            Logger.getLogger(PersistManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PersistManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersistManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * shuts down the persistence.
     */
    public void shutdown() {
        manager.close();
        factory.close();
        try {
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/monsters", "", "");
            Statement stmt = c.createStatement();
            stmt.execute("SHUTDOWN");
        } catch (SQLException ex) {
            Logger.getLogger(PersistManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
