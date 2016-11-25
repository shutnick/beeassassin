package com.example.moreno.beeassassin.model;

/**
 * Created on 23.11.2016.
 */

public class Queen extends BaseBee {

    public Queen() {
        healthPoints = getFullHP();
        takenDamage = getDamageTaken();
    }


    @Override
    public BeeType getType() {
        return BeeType.QUEEN;
    }

    @Override
    public int getFullHP() {
        return 100;
    }

    @Override
    public int getDamageTaken() {
        return 8;
    }

    @Override
    public void takeDamage() {
        healthPoints -= takenDamage;
    }
}