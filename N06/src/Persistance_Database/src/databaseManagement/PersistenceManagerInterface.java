/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

import java.util.List;

/**
 * PersistanceManager Interface.
 * @author Dan
 */
public interface PersistenceManagerInterface {

    public void init();

    public void create(Monster monster);

    public void create(User user);

    public boolean update(User user);

    public boolean update(Monster monster);

    public boolean remove(User user);

    public boolean remove(Monster monster);

    public List<Monster> search(String username);

    public List<User> search();

    public void shutdown();
    
    public void addToShop(Monster monster);
    
    public void removeFromShop(Monster monster);
    
    public List<Monster> getAllShop();
}
