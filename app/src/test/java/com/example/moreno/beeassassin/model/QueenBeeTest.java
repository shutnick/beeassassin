package com.example.moreno.beeassassin.model;

import android.test.suitebuilder.annotation.LargeTest;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.Queen;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by sso on 11/24/16.
 */

public class QueenBeeTest {

    @Test
    public void testOneHitExpectedHealthChangedAlive() {
        BaseBee queen = new Queen();
        queen.takeDamage();
        int expectedHealth = 92;
        Assert.assertEquals(expectedHealth, queen.getCurrentHealth());
        Assert.assertFalse(queen.isDead());
    }

    @Test
    public void testKillExpectedDead() {
        BaseBee queen = new Queen();
        int hitsToKill = (100 - 1)/ 8 + 1;

        for (int i = 0; i < hitsToKill; i++) {
            queen.takeDamage();
        }

        Assert.assertTrue(queen.isDead());
    }

    @Test
    public void testMaxHitsExpectedAlive() {
        BaseBee queen = new Queen();
        int hitsToKill = (100 - 1) / 8;

        for (int i = 0; i < hitsToKill; i++) {
            queen.takeDamage();
        }

        Assert.assertFalse(queen.isDead());
    }
}
