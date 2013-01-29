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
 *
 * @author Dan
 */
public class PersistManager {

    private EntityManager manager;
    private EntityManagerFactory factory;
    private List<Monster> monsterList;
    private List<Monster> userMonsters;
    private List<User> userList;
    private List<Monster> shopList;

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

    public void create(User user) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            manager.persist(user);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        }
        System.out.println(user.getName() + " has been created.");
    }

    public boolean update(User user) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            User theUser = manager.find(User.class, user.getName());
            theUser.setPassword(user.getPassword());
            theUser.setVirtualMoney(user.getVirtualMoney());
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            return false;
        }
    }

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

    public boolean remove(User user) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            User theUser = manager.find(User.class, user.getName());
            List<Monster> temp = searchMonsters(theUser.getName());
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
     * Returns list of Monsters owned by the passed user.
     *
     * @param username
     * @return
     */
    public List<Monster> searchMonsters(String username) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select m from Monster m where m.owner='" + username + "'");
        tx.commit();
        userMonsters = (List<Monster>) query.getResultList();
        return userMonsters;
    }

    public List<Monster> searchMonsters() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select m from Monster m");
        tx.commit();
        monsterList = (List<Monster>) query.getResultList();
        return monsterList;
    }

    public List<User> searchUsers() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select u from User u");
        tx.commit();
        userList = (List<User>) query.getResultList();
        return userList;
    }

    public List<Monster> searchShopMonsters() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select m from Monster m where m.owner='" + "'");
        tx.commit();
        shopList = (List<Monster>) query.getResultList();
        return shopList;
    }

    public void init() {
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            factory = Persistence.createEntityManagerFactory("monsters");
            manager = factory.createEntityManager();
        } catch (InstantiationException ex) {
            Logger.getLogger(PersistManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PersistManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(PersistManager.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    public void shutdown() {
            manager.close();
            factory.close();
            try {
                Connection c = DriverManager.getConnection("jdbc:hsqldb:file:monsters", "", "");
                Statement stmt = c.createStatement();
                stmt.execute("SHUTDOWN");
        } catch (SQLException ex) {
            Logger.getLogger(PersistManager.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}