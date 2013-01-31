/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.*;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class that contains methods that relate to
 * breeding of monsters.
 * @author Dan
 */
public class Breed {

    Random rand = new Random();
    
    /**
     * Function to return the monster created by
     * breeding the two provided parents.
     * @param m1
     * @param m2
     * @param monsterName
     * @param userName
     * @return Monster based on two parents.
     */
    public Monster breedMonsters(Monster m1, 
            Monster m2, String monsterName, 
            String userName){
        int[] statArray = new int[4];
        int[] alterStat = new int[4];
        int[] finalStat = new int[4];
        if (generalAssess(m1) < generalAssess(m2)) {
            alterStat[0] = m1.getHeight();
            alterStat[1] = m1.getMaxAge();
            alterStat[2] = m1.getAggression();
            alterStat[3] = m1.getStrength();

            statArray[0] = m2.getHeight();
            statArray[1] = m2.getMaxAge();
            statArray[2] = m2.getAggression();
            statArray[3] = m2.getStrength();
        } else {
            alterStat[0] = m2.getHeight();
            alterStat[1] = m2.getMaxAge();
            alterStat[2] = m2.getAggression();
            alterStat[3] = m2.getStrength();

            statArray[0] = m1.getHeight();
            statArray[1] = m1.getMaxAge();
            statArray[2] = m1.getAggression();
            statArray[3] = m1.getStrength();
        }
        for (int i = 0; i < alterStat.length; i++) {
            finalStat[i] = makeAttribute(alterStat[i],
                    statArray[i]);
        }
        Monster newMonster = MonsterFactory.makeIt(
                monsterName, finalStat[0], 
                finalStat[1], finalStat[2], 
                finalStat[3], userName);
        
        
            try {
                passToPM(newMonster);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Breed.class.getName())
                        .log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Breed.class.getName())
                        .log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Breed.class.getName())
                        .log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Breed.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        return newMonster;
    }

    /**
     * Takes two monster attributes and creates a new
     * attribute based on the two provided.
     * @param attrib1
     * @param attrib2
     * @return int the new attribute.
     */
    public int makeAttribute(int attrib1, int attrib2){   
            int midStat = attrib1 + (
                    (attrib2 - attrib1)/2);    
            int min = -(attrib1 / 8);
            int max = (attrib1 / 4);
            int randomStat = 
                    rand.nextInt(max - min + 1) + min;
            int finalStat = randomStat + midStat;
        return finalStat;
    }

    /**
     * Shows how good a monster is by adding various
     * attributes.
     * @param m
     * @return int the monster's rating.
     */
    public int generalAssess(Monster m) {
        return (m.getAggression() + m.getStrength());
    }
    
    /**
     * Stores a monster in the persistence manager.
     * @param monster
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public void passToPM(Monster monster) 
            throws ClassNotFoundException, 
            SQLException, InstantiationException, 
            IllegalAccessException {
        PersistManager persistIt = 
                new PersistManager();
         try {
            persistIt.init();
            persistIt.create(monster);
        } catch (RuntimeException ex) {
        } finally {
            persistIt.shutdown();
        }
    }
}
