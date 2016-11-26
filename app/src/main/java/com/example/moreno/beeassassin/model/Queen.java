package com.example.moreno.beeassassin.model;

/**
 * Created on 23.11.2016.
 */

public class Queen extends BaseBee {

    public Queen() {
        healthPoints = getType().getFullHp();
        takenDamage = getType().getDamageTaken();
    }


    @Override
    public BeeType getType() {
        return BeeType.QUEEN;
    }
}
