package com.example.moreno.beeassassin.model;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.Queen;
import com.example.moreno.beeassassin.model.Worker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sso on 11/24/16.
 */

public class WorkerBeeTest {

    private BaseBee worker;

    @Before
    public void init() {
        worker = new Worker();
    }


    @Test
    public void testOneHitExpectedHealthChangedAlive() {
        int expectedHealth = worker.getFullHP() - worker.getDamageTaken();
        worker.takeDamage();
        Assert.assertEquals(expectedHealth, worker.getCurrentHealth());
        Assert.assertFalse(worker.isDead());
    }

    @Test
    public void testKillExpectedDead() {
        int hitsToKill = (worker.getFullHP() - 1)/ worker.getDamageTaken() + 1;

        for (int i = 0; i < hitsToKill; i++) {
            worker.takeDamage();
        }

        Assert.assertTrue(worker.isDead());
    }

    @Test
    public void testMaxHitsExpectedAlive() {
        int maxHits = (worker.getFullHP() - 1)/ worker.getDamageTaken();

        for (int i = 0; i < maxHits; i++) {
            worker.takeDamage();
        }

        Assert.assertFalse(worker.isDead());
    }
}
