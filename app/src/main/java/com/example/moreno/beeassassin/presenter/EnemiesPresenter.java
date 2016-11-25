package com.example.moreno.beeassassin.presenter;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.BeeType;

import java.util.ArrayList;

/**
 * Created on 23.11.2016.
 */

public class EnemiesPresenter implements IEnemies{

    public static final String TAG = EnemiesPresenter.class.getSimpleName();
    private ArrayList<BaseBee> bees;
    private IGamePresenter gamePresenter;

    public EnemiesPresenter(ArrayList<BaseBee> enemies) {
        bees = enemies;
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
                gamePresenter.finish();
            }
        }
    }

    @Override
    public int getAliveCount() {
        return bees.size();
    }

    @Override
    public void attachGamePresenter(IGamePresenter gamePresenter) {
        this.gamePresenter = gamePresenter;
    }
}
