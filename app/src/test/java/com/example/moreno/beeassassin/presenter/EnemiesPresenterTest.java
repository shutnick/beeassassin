package com.example.moreno.beeassassin.presenter;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.Drone;
import com.example.moreno.beeassassin.model.Queen;
import com.example.moreno.beeassassin.model.Worker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by sso on 11/25/16.
 */

public class EnemiesPresenterTest {

    private IEnemies enemies;
    private final int QUEEN_INDEX = 3;
    private ArrayList<BaseBee> mockBees;

    @Before
    public void init() {
        mockBees = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i == QUEEN_INDEX) {
                mockBees.add(new Queen());
            } else {
                mockBees.add(new Drone());
            }
        }
        enemies = new EnemiesPresenter(mockBees);
    }


    @Test
    public void testHitBee() {
        enemies.hit(QUEEN_INDEX);
        BaseBee queen = mockBees.get(QUEEN_INDEX);
        Assert.assertNotEquals(queen.getCurrentHealth(), queen.getFullHP());
    }

    @Test
    public void testBuryBeeExpectedAliveLessQueenAbsent() {
        int expectedCount = enemies.getAliveCount() - 1;
        BaseBee queen = mockBees.get(QUEEN_INDEX);
        enemies.bury(QUEEN_INDEX);
        Assert.assertEquals(expectedCount, enemies.getAliveCount());
        Assert.assertFalse(mockBees.contains(queen));
    }

    @Test
    public void testBuryBeeIncorrectIndexesExpectedAliveSame() {
        int expectedAlive = enemies.getAliveCount();
        enemies.bury(-1);
        enemies.bury(Integer.MAX_VALUE);

        Assert.assertEquals(expectedAlive, enemies.getAliveCount());

    }

    @Test
    public void testHitBeeIncorrectIndexesExpectedFullHp() {
        enemies.hit(-1);
        enemies.hit(Integer.MAX_VALUE);

        for (BaseBee bee : mockBees) {
            Assert.assertEquals(bee.getFullHP(), bee.getCurrentHealth());
        }

    }
}
