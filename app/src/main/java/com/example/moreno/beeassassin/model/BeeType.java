package com.example.moreno.beeassassin.model;

/**
 * Created on 23.11.2016.
 */

public enum BeeType {
    QUEEN(100, 8),
    WORKER(75, 10),
    DRONE(50, 12);
    private int fullHp;
    private int damageTaken;

    BeeType(int fullHp, int damageTaken) {
        this.fullHp = fullHp;
        this.damageTaken = damageTaken;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public int getFullHp() {
        return fullHp;
    }
}
