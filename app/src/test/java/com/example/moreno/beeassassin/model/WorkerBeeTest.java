package com.example.moreno.beeassassin.model;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.Queen;
import com.example.moreno.beeassassin.model.Worker;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sso on 11/24/16.
 */

public class WorkerBeeTest {

    @Test
    public void testOneHitExpectedHealthChangedAlive() {
        BaseBee worker = new Worker();
        worker.takeDamage();
        int expectedHealth = 65;
        Assert.assertEquals(expectedHealth, worker.getCurrentHealth());
        Assert.assertFalse(worker.isDead());
    }

    @Test
    public void testKillExpectedDead() {
        BaseBee worker = new Worker();
        int hitsToKill = (75 - 1) / 10 + 1;

        for (int i = 0; i < hitsToKill; i++) {
            worker.takeDamage();
        }

        Assert.assertTrue(worker.isDead());
    }

    @Test
    public void testMaxHitsExpectedAlive() {
        BaseBee worker = new Worker();
        int hitsToKill = (75 - 1) / 10;

        for (int i = 0; i < hitsToKill; i++) {
            worker.takeDamage();
        }

        Assert.assertFalse(worker.isDead());
    }
}
