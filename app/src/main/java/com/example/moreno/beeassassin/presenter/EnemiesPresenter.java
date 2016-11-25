package com.example.moreno.beeassassin.presenter;

import android.util.Log;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.BeeType;
import com.example.moreno.beeassassin.model.Drone;
import com.example.moreno.beeassassin.model.Queen;
import com.example.moreno.beeassassin.model.Worker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 23.11.2016.
 */

public class EnemiesPresenter implements IEnemies{

    public static final String TAG = EnemiesPresenter.class.getSimpleName();
    private ArrayList<BaseBee> bees;

    public EnemiesPresenter(ArrayList<BaseBee> enemies) {
        bees = enemies;
    }

    @Override
    public void bury(int enemyIndex) {
        if (enemyIndex < 0 || enemyIndex > bees.size()) {
            return;
        }
        bees.remove(enemyIndex);
    }

    @Override
    public void hit(int enemyIndex) {
        if (enemyIndex < 0 || enemyIndex > bees.size()) {
            return;
        }

        BaseBee bee = bees.get(enemyIndex);
        bee.takeDamage();

        if (bee.isDead()) {
            bees.remove(bee);
            if (bee.getType() == BeeType.QUEEN) {
                //finish
            }
        }


    }

    @Override
    public int getAliveCount() {
        return bees.size();
    }
}
