package com.example.moreno.beeassassin.model;

/**
 * Created on 23.11.2016.
 */

public class Queen extends BaseBee {


    @Override
    public BeeType getType() {
        return BeeType.QUEEN;
    }

    @Override
    public int getFullHP() {
        return 0;
    }

    @Override
    public int getDamageTaken() {
        return 0;
    }

    @Override
    public void takeDamage() {

    }
}
