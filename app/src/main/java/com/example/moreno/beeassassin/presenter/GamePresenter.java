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
    EnemiesPresenter enemiesPresenter;

    public GamePresenter() {
        random = new Random();
        enemiesPresenter = new EnemiesPresenter(createBees());
    }

    @NonNull
    private ArrayList<BaseBee> createBees() {
        ArrayList<BaseBee> bees = new ArrayList<>();
        bees.add(new Queen());

        bees.add(new Worker());
        bees.add(new Worker());
        bees.add(new Worker());
        bees.add(new Worker());
        bees.add(new Worker());

        bees.add(new Drone());
        bees.add(new Drone());
        bees.add(new Drone());
        bees.add(new Drone());
        bees.add(new Drone());
        bees.add(new Drone());
        bees.add(new Drone());
        bees.add(new Drone());
        return bees;
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
