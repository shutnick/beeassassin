package com.example.moreno.beeassassin.presenter;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.BeeType;
import com.example.moreno.beeassassin.view.IViewCallback;

import java.util.Random;

/**
 * Created on 23.11.2016.
 */

public class GamePresenter implements IGamePresenter{
    Random random;
    IEnemies enemiesPresenter;
    IViewCallback viewCallback;

    public GamePresenter(IEnemies enemiesPresenter, IViewCallback callback) {
        random = new Random();
        this.enemiesPresenter = enemiesPresenter;
        enemiesPresenter.attachGamePresenter(this);
        viewCallback = callback;
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
    public void onDamageDealt(BaseBee bee, int enemyIndex) {
        viewCallback.refresh(bee, enemyIndex);
        if (bee.getType() == BeeType.QUEEN) {
            finish();
        }
    }
}
