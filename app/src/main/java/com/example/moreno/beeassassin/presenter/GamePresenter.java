package com.example.moreno.beeassassin.presenter;

import android.support.annotation.NonNull;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.BeeType;
import com.example.moreno.beeassassin.model.Drone;
import com.example.moreno.beeassassin.model.Queen;
import com.example.moreno.beeassassin.model.Worker;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created on 23.11.2016.
 */

public class GamePresenter implements IGamePresenter{
    Random random;
    IEnemies enemiesPresenter;

    public GamePresenter(IEnemies enemiesPresenter) {
        random = new Random();
        this.enemiesPresenter = enemiesPresenter;
        enemiesPresenter.attachGamePresenter(this);
    }

    @Override
    public void hit() {
        int randomBeeIndex = random.nextInt(enemiesPresenter.getAliveCount());
        enemiesPresenter.hit(randomBeeIndex);
    }

    @Override
    public void finish() {

    }

    @Override
    public void onDamageDealt(BeeType type) {

    }
}
