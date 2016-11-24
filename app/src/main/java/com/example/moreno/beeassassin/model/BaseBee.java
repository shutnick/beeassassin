package com.example.moreno.beeassassin.model;

/**
 * Created on 23.11.2016.
 */

public abstract class BaseBee {
    protected int healthPoints;
    protected int takenDamage;

    public abstract BeeType getType();
    public abstract int getFullHP();
    public abstract int getDamageTaken();
    public abstract void takeDamage();
    public final boolean isDead() {
        return healthPoints <= 0;
    }
}
