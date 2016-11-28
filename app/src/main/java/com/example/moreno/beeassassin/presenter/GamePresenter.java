package com.example.moreno.beeassassin.presenter;

import com.example.moreno.beeassassin.config.EnemiesConfig;
import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.BeeType;
import com.example.moreno.beeassassin.util.BeeGenerator;
import com.example.moreno.beeassassin.view.IViewCallback;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created on 23.11.2016.
 */

public class GamePresenter implements IGamePresenter{
    Random random;
    IEnemies enemiesPresenter;
    IViewCallback viewCallback;

    public GamePresenter() {
        this(BeeGenerator.createBees(
                EnemiesConfig.QUEENS_AMOUNT,
                EnemiesConfig.WORKERS_AMOUNT,
                EnemiesConfig.DRONES_AMOUNT));
    }

    public GamePresenter(ArrayList<BaseBee> bees) {
        enemiesPresenter = new EnemiesStateHolder(bees);
        enemiesPresenter.attachGamePresenter(this);

        random = new Random();
    }

    @Override
    public void hit() {
        int randomBeeIndex = random.nextInt(enemiesPresenter.getAliveCount());
        enemiesPresenter.hit(randomBeeIndex);
    }

    @Override
    public void onDamageDealt(BaseBee bee, int enemyIndex) {
        viewCallback.refresh(bee, enemyIndex);
        if (bee.getType() == BeeType.QUEEN && bee.isDead()) {
            viewCallback.showFinish();
        }
    }

    @Override
    public void restoreProgress() {
        viewCallback.restoreViews(enemiesPresenter.getState());
    }

    @Override
    public void onCreate(IViewCallback viewCallback) {
        this.viewCallback = viewCallback;
    }

    @Override
    public void onDestroy() {
        viewCallback = null;
    }


}
