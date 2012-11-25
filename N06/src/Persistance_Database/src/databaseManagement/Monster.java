/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseManagement;

import javax.persistence.*;

/**
 * Persistable Monster object. Id = primary key, also an automatically generated value.
 * Tags make it work and come with the hibernate library, they will not work without it.
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
    private int strength;
    private int aggression;
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAggression(int aggression) {
        this.aggression = aggression;
    }
    
    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public int getStrength() {
        return strength;
    }

    public int getAggression() {
        return aggression;
    }
}