/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

/**
 *
 * @author Dan
 */
public class MakeMonster {
    
    public static Monster makeIt(String name, int height, int age, int aggression, int strength, String owner) {
        Monster newMonster = new Monster();
        newMonster.setName(name);
        newMonster.setHeight(height);
        newMonster.setAge(age);
        newMonster.setAggression(aggression);
        newMonster.setStrength(strength);
        newMonster.setOwner(owner);
        return newMonster;
    }
}
