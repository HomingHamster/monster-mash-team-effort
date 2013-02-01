/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Contains all of the methods that relate to a monster. Monster is an entity class that
 * is persisted into the database.
 * @author Dan
 */
@Entity
public class Monster {

    @Id
    @GeneratedValue
    private int Id;
    private String name;
    private int height;
    private int age;
    private int maxAge;
    private int strength;
    private int aggression;
    private int worth;
    private boolean isDead;
    private boolean isImmortal;
    private String owner;
    /**
     * gets the monster's owner
     * @return String owner.
     */
    public String getOwner() {
        return owner;
    }
    /**
     * sets a new owner for the monster.
     * @param owner 
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
   /**
     * sets the name of the monster.
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
   /**
     * sets the height of a monster.
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * sets the age of the monster
     * @param age 
     */
    public void setAge(int age) {
        this.age = age;
    }
        /**
     * sets the age the monster will die at
     * @param maxAge 
     */
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }
    /**
     * sets the strength of a monster.
     * @param strength 
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }
    /**
     * sets the aggression level of a monster
     * @param aggression 
     */
    public void setAggression(int aggression) {
        this.aggression = aggression;
    }
    /**
     * gets the monster's id.
     * @return int id
     */
    public int getId() {
        return Id;
    }
    /**
     * gets the name of the monster.
     * @return String name.
     */
    public String getName() {
        return name;
    }
   /**
     * gets the height of the monster.
     * @return int height
     */
    public int getHeight() {
        return height;
    }
    /**
     * gets the monster's age
     * @return int age
     */
    public int getAge() {
        return age;
    }
    /**
     * gets the age the monster will die at.
     * @return int maximum age.
     */
    public int getMaxAge() {
        return maxAge;
    }
    /**
     * gets the strength of a monster.
     * @return int strength.
     */
    public int getStrength() {
        return strength;
    }
    /**
     * gets the aggression of the monster.
     * @return int aggression.
     */
    public int getAggression() {
        return aggression;
    }
    /**
     * sets the worth of the monster for use in
     * the shop.
     * @param worth 
     */
    public void setWorth(int worth) {
        this.worth = worth;
    }
    /**
     * gets the worth of the monster for use in
     * the shop.
     * @return 
     */
    public int getWorth() {
        return worth;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    public boolean isIsDead() {
        return isDead;
    }
    
        public void setIsImmortal(boolean isImmortal) {
        this.isImmortal = isImmortal;
    }

    public boolean isIsImmortal() {
        return isImmortal;
    }
}