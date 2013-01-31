/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

import monsterMashGroupProject.Worth;

/**
 * Contains the methods that relate to creation of monsters.
 * @author Dan
 */
public class MonsterFactory {
    
    /**
     * creates a monster with given values for the attributes.
     * @param name
     * @param height
     * @param maxAge
     * @param aggression
     * @param strength
     * @param owner
     * @return Monster monster.
     */
    public static Monster makeIt(String name, int height, int maxAge, int aggression, int strength, String owner) {
        Monster newMonster = new Monster();
        newMonster.setName(name);
        newMonster.setHeight(height);
        newMonster.setMaxAge(maxAge);
        newMonster.setAge(0);
        newMonster.setAggression(aggression);
        newMonster.setStrength(strength);
        newMonster.setWorth(0);
        //newMonster.setIsDead(false);
        newMonster.setOwner(owner);
        return newMonster;
    }
}
