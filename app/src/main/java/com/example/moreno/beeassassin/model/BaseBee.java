package com.example.moreno.beeassassin.model;

/**
 * Created on 23.11.2016.
 */

public abstract class BaseBee {
    protected int healthPoints;
    protected int takenDamage;

    public abstract BeeType getType();
    public void takeDamage() {
        healthPoints -= takenDamage;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
    }
    public final int getCurrentHealth() {
        return healthPoints;
    }
    public final boolean isDead() {
        return healthPoints == 0;
    }
}
