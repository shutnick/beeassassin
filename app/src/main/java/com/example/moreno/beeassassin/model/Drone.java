package com.example.moreno.beeassassin.model;

/**
 * Created on 23.11.2016.
 */

public class Drone extends BaseBee {

    public Drone() {
        healthPoints = getFullHP();
        takenDamage = getDamageTaken();
    }


    @Override
    public BeeType getType() {
        return BeeType.DRONE;
    }

    @Override
    public int getFullHP() {
        return 50;
    }

    @Override
    public int getDamageTaken() {
        return 12;
    }

    @Override
    public void takeDamage() {
        healthPoints -= takenDamage;
    }
}
