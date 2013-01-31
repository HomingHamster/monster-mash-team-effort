/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterMashGroupProject;

import databaseManagement.*;

/**
 * Contains methods relating to calculating a
 * monster's worth.
 * @author dam44
 */
public class Worth {
    /**
     * Calculates the worth of a monster.
     * @param monster
     * @return 
     */
    private PersistManager persistIt;

    public int Worth(Monster monster) {
        return (((monster.getStrength() + monster.getAggression()) * assessAge(monster)) / 10);
    }
    /**
     * Updates the worth of a monster.
     * @param monster 
     */
    public void UpdateMonsterWorth(Monster monster) {
        persistIt = new PersistManager();
        persistIt.init();
        monster.setWorth(Worth(monster));
        persistIt.update(monster);
        persistIt.shutdown();
    }

    /**
     * Out of 10. If they are younger or older than middle aged (between 40 and
     * 60 percent of their max age) then the assessment number decreases which
     * hence deceases the over-all likely-hood of winning for the monster.
     */
        /**
     * assess the age of a monster.
     * @param m
     * @return int age.
     */
    public static int assessAge(Monster m) {
        double age = (double) m.getAge();
        double maxAge = (double) m.getMaxAge();
        int ageAssess = 10;
        boolean done = false;
        double lower = 0.4;
        double higher = 0.6;
        while (done == false) {
            if ((age >= (maxAge * lower)) && (age <= (maxAge * higher))) {
                    done = true;
            } else {
                if ((higher > 1) || (lower < 0)) {
                    System.out.println("Error assessing monster age.");
                    done = true;
                } else {
                    ageAssess--;
                    lower = lower - 0.1;
                    higher = higher + 0.1;
                    done = false;
                }
            }
        }
        return ageAssess;
    }
}
