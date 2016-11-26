package com.example.moreno.beeassassin.presenter;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.stubs.StubBeeViewCallback;
import com.example.moreno.beeassassin.util.BeeGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by sso on 11/25/16.
 */

public class GamePresenterTest {
    private IGamePresenter gamePresenter;
    private ArrayList<BaseBee> mockBees;

    @Before
    public void init() {
        mockBees = BeeGenerator.createBees(1, 5, 7);
        gamePresenter = new GamePresenter(new EnemiesPresenter(mockBees), new StubBeeViewCallback());
    }

    @Test
    public void testHitOneBeeExpectedHpChangedOnce() {
        int expectedDamagedCount = 1;
        int damagedBeeCount = 0;

        gamePresenter.hit();
        for (BaseBee bee : mockBees) {
            if (bee.getFullHP() != bee.getCurrentHealth()) {
                damagedBeeCount++;
            }
        }

        Assert.assertEquals(expectedDamagedCount, damagedBeeCount);
    }

}
