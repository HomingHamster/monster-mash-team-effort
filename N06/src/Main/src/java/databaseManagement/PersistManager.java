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
    public MyUser getUpdatedUser(MyUser user) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("SELECT u FROM MyUser u WHERE u.username='" + user.getUsername() + "'");
        tx.commit();
        userList = (List<MyUser>) query.getResultList();
        return userList.get(0);
    }

    public Monster getUpdatedMonster(MyUser user, Monster monster) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("SELECT m FROM Monster m WHERE m.owner='" + user.getUsername() + "' AND m.name='" + monster.getName() + "' ");
        tx.commit();
        monsterList = (List<Monster>) query.getResultList();
        return monsterList.get(0);
    }

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

    public List<Requests> searchRequets() {

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select r from Requests r");
        tx.commit();
        requests = (List<Requests>) query.getResultList();
        return requests;
    }

    public List<Requests> searchRequets(String username) {

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select r from Requests r where r.userTo='" + username + "'");
        tx.commit();
        requests = (List<Requests>) query.getResultList();
        return requests;
    }

    public List<Monster> searchGraveYard(String username) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("SELECT m FROM Monster m WHERE m.owner='" + username + "' AND m.isDead=1");
        tx.commit();
        userMonsters = (List<Monster>) query.getResultList();
        return userMonsters;
    }

    public List<MyUser> searchUsers() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select u from MyUser u");
        tx.commit();
        userList = (List<MyUser>) query.getResultList();
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

    public List<Friends> searchFriends(String theUser) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("select f from Friends f where f.myUser='" + theUser + "'");
        tx.commit();
        friends = (List<Friends>) query.getResultList();
        return friends;
    }

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
