package com.example.moreno.beeassassin.model;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.Worker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sso on 11/24/16.
 */

public class DroneBeeTest {

    private BaseBee drone;

    @Before
    public void init() {
        drone = new Drone();
    }

    @Test
    public void testOneHitExpectedHealthChangedAlive() {
        drone.takeDamage();
        int expectedHealth = drone.getFullHP() - drone.getDamageTaken();
        Assert.assertEquals(expectedHealth, drone.getCurrentHealth());
        Assert.assertFalse(drone.isDead());
    }

    @Test
    public void testKillExpectedDead() {
        int hitsToKill = (drone.getFullHP() - 1)/ drone.getDamageTaken() + 1;

        for (int i = 0; i < hitsToKill; i++) {
            drone.takeDamage();
        }

        Assert.assertTrue(drone.isDead());
    }

    @Test
    public void testMaxHitsExpectedAlive() {
        int maxHits = (drone.getFullHP() - 1)/ drone.getDamageTaken();

        for (int i = 0; i < maxHits; i++) {
            drone.takeDamage();
        }

        Assert.assertFalse(drone.isDead());
    }
}
