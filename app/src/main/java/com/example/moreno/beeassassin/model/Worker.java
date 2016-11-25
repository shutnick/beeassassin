package com.example.moreno.beeassassin.model;

/**
 * Created on 23.11.2016.
 */

public class Worker extends BaseBee {

    public Worker() {
        healthPoints = getFullHP();
        takenDamage = getDamageTaken();
    }


    @Override
    public BeeType getType() {
        return BeeType.WORKER;
    }

    @Override
    public int getFullHP() {
        return 75;
    }

    @Override
    public int getDamageTaken() {
        return 10;
    }

    @Override
    public void takeDamage() {
        healthPoints -= takenDamage;
    }
}
