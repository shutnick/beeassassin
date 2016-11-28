package com.example.moreno.beeassassin.presenter;

import com.example.moreno.beeassassin.model.BaseBee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 23.11.2016.
 */

public class EnemiesStateHolder implements IEnemies{

    public static final String TAG = EnemiesStateHolder.class.getSimpleName();
    private ArrayList<BaseBee> bees;
    private ArrayList<Integer> aliveBeeIndexes;

    private IGamePresenter gamePresenter;

    public EnemiesStateHolder(ArrayList<BaseBee> enemies) {
        bees = enemies;
        saveBeeIndexes(bees);
    }

    private void saveBeeIndexes(ArrayList<BaseBee> bees) {
        aliveBeeIndexes  = new ArrayList<>(bees.size());
        for (int i = 0; i < bees.size(); i++) {
            aliveBeeIndexes.add(i);
        }
    }

    @Override
    public void hit(int enemyIndex) {
        if (enemyIndex < 0 || enemyIndex >= aliveBeeIndexes.size()) {
            return;
        }

        int internalBeeIndex = aliveBeeIndexes.get(enemyIndex);
        BaseBee bee = bees.get(internalBeeIndex);
        bee.takeDamage();

        if (bee.isDead()) {
            aliveBeeIndexes.remove(enemyIndex);

        }

       gamePresenter.onDamageDealt(bee, internalBeeIndex);
    }

    @Override
    public int getAliveCount() {
        return aliveBeeIndexes.size();
    }

    @Override
    public void attachGamePresenter(IGamePresenter gamePresenter) {
        this.gamePresenter = gamePresenter;
    }

    @Override
    public List<BaseBee> getState() {
        return new ArrayList<>(bees);
    }
}
