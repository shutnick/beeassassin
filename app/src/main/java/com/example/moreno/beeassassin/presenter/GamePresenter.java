package com.example.moreno.beeassassin.presenter;

import com.example.moreno.beeassassin.model.BeeType;

import java.util.Random;

/**
 * Created on 23.11.2016.
 */

public class GamePresenter implements IGamePresenter{
    Random random = new Random();
    EnemiesPresenter enemiesPresenter = new EnemiesPresenter();

    @Override
    public void hit() {
        enemiesPresenter.hit(random.nextInt(enemiesPresenter.getAliveCount()));
    }

    @Override
    public void finish() {

    }

    @Override
    public void onDamageDealt(BeeType type) {

    }
}
