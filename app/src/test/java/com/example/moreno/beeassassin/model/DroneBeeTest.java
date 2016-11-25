package com.example.moreno.beeassassin.model;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.Worker;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sso on 11/24/16.
 */

public class DroneBeeTest {

    @Test
    public void testOneHitExpectedHealthChangedAlive() {
        BaseBee drone = new Drone();
        drone.takeDamage();
        int expectedHealth = drone.getFullHP() - drone.getDamageTaken();
        Assert.assertEquals(expectedHealth, drone.getCurrentHealth());
        Assert.assertFalse(drone.isDead());
    }

    @Test
    public void testKillExpectedDead() {
        BaseBee drone = new Drone();
        int hitsToKill = (drone.getFullHP() - 1)/ drone.getDamageTaken() + 1;

        for (int i = 0; i < hitsToKill; i++) {
            drone.takeDamage();
        }

        Assert.assertTrue(drone.isDead());
    }

    @Test
    public void testMaxHitsExpectedAlive() {
        BaseBee drone = new Drone();
        int maxHits = (drone.getFullHP() - 1)/ drone.getDamageTaken();

        for (int i = 0; i < maxHits; i++) {
            drone.takeDamage();
        }

        Assert.assertFalse(drone.isDead());
    }
}
