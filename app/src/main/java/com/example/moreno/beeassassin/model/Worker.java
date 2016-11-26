package com.example.moreno.beeassassin.model;

/**
 * Created on 23.11.2016.
 */

public class Worker extends BaseBee {

    public Worker() {
        healthPoints = getType().getFullHp();
        takenDamage = getType().getDamageTaken();
    }


    @Override
    public BeeType getType() {
        return BeeType.WORKER;
    }

}
