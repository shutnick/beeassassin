package com.example.moreno.beeassassin.model;

import android.test.suitebuilder.annotation.LargeTest;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.Queen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by sso on 11/24/16.
 */

public class QueenBeeTest {
    private BaseBee queen;

    @Before
    public void init() {
        queen = new Queen();
    }

    @Test
    public void testOneHitExpectedHealthChangedAlive() {
        int expectedHealth = queen.getFullHP() - queen.getDamageTaken();

        queen.takeDamage();
        Assert.assertEquals(expectedHealth, queen.getCurrentHealth());
        Assert.assertFalse(queen.isDead());
    }

    @Test
    public void testKillExpectedDead() {
        int hitsToKill = (queen.getFullHP() - 1)/ queen.getDamageTaken() + 1;

        for (int i = 0; i < hitsToKill; i++) {
            queen.takeDamage();
        }

        Assert.assertTrue(queen.isDead());
    }

    @Test
    public void testMaxHitsExpectedAlive() {
        int maxHits = (queen.getFullHP() - 1)/ queen.getDamageTaken();
        for (int i = 0; i < maxHits; i++) {
            queen.takeDamage();
        }

        Assert.assertFalse(queen.isDead());
    }
}
