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
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

/**
 *
 * @author Dan
 * PersistManager is used to handle transactions with the database.
 */
public class PersistManager {

    private EntityManager manager;
    private EntityManagerFactory factory;
    private List<Monster> monsterList;
    private List<Monster> userMonsters;
    private List<MyUser> userList;
    private List<Monster> shopList;
    private List<Requests> requests;
    private List<Friends> friends;

    /**
     * Adds monsters to the database.
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
    }

    /**
     * Adds requests to the database.
     * @param request 
     */
    public void create(Requests request) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            manager.persist(request);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        }
    }

    /**
     * Adds friends to the database.
     * @param friend 
     */
    public void create(Friends friend) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            manager.persist(friend);
            tx.commit();
        } catch (Exception ex) {
            //tx.rollback();
        }
    }

    /**
     * Adds users to the database.
     * @param user 
     */
    public void create(MyUser user) {
        EntityTransaction tx = manager.getTransaction();

        tx.begin();
        try {
            manager.persist(user);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        }
    }

    /**
     * Updates a user in the database.
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
     * Updates monsters in the database.
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
     * Updates a friend in the database.
     * @param friend
     * @return 
     */
    public boolean update(Friends friend) {

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            Friends theFriend = manager.find(Friends.class, friend.getId());
            theFriend.setFriendUsername(friend.getFriendUsername());
            theFriend.setMyUser(friend.getMyUser());
            theFriend.setUrl(friend.getUrl());

            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            return false;
        }

    }

    /**
     * Updates a request in the database.
     * @param request
     * @return 
     */
    public boolean update(Requests request) {

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            Requests theRequest = manager.find(Requests.class, request.getType());
            theRequest.setType(request.getType());
            theRequest.setUserTo(request.getUserTo());
            theRequest.setIpAddress(request.getIpAddress());
            theRequest.setFromWho(request.getFromWho());
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
     * @return 
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
     * Removes a monster from the database.
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
     * Removes a request from the database.
     * @param request
     * @return 
     */
    public boolean remove(Requests request) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            Request theRequest = manager.find(Request.class, request.getId());
            manager.remove(theRequest);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            return false;
        }
    }

    /**
     * Removes a friend from the database.
     * @param friend
     * @return 
     */
    public boolean remove(Friends friend) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            Friends theFriend = manager.find(Friends.class, friend.getId());
            manager.remove(theFriend);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            return false;
        }
    }

    /**
     * Drops a table from the database.
     * @param table
     * @return 
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
     * Gets the most recent version of a user from the database.
     *
     * @param username
     * @return
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
     * Gets the most recent version of a monster from the database.
     * @param user
     * @param monster
     * @return 
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
     * Retrieves all the monsters a user owns and returns them in a list.
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

    /**
     * Returns all monsters.
     * @return 
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
     * Gets all requests.
     */
    public List<Requests> searchRequets() {

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select r from Requests r");
        tx.commit();
        requests = (List<Requests>) query.getResultList();
        return requests;
    }

    /**
     * Returns all requests for a user.
     * @param username
     * @return 
     */
    public List<Requests> searchRequets(String username) {

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select r from Requests r where r.userTo='" + username + "'");
        tx.commit();
        requests = (List<Requests>) query.getResultList();
        return requests;
    }

    /**
     * Retrieves all dead monsters.
     * (Monsters are currently removed when dead so method is not currently used in system.)
     * @param username
     * @return 
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
     * Returns all users.
     * @return 
     */
    public List<MyUser> searchUsers() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select u from MyUser u");
        tx.commit();
        userList = (List<MyUser>) query.getResultList();
        return userList;
    }

    /**
     * Returns all monsters in the shop. Shop monsters do not have an owner (that is the difference).
     * @return 
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
     * Returns all friends for a user.
     * @param theUser
     * @return 
     */
    public List<Friends> searchFriends(String theUser) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select f from Friends f where f.myUser='" + theUser + "'");
        tx.commit();
        friends = (List<Friends>) query.getResultList();
        return friends;
    }

    /**
     * Initialises the persistence manager and connects to the database.
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
     * Shuts down the persistence manager and exits from the database.
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
