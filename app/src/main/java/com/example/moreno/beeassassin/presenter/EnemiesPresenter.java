package com.example.moreno.beeassassin.presenter;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.BeeType;

import java.util.ArrayList;

/**
 * Created on 23.11.2016.
 */

public class EnemiesPresenter implements IEnemies{

    private ArrayList<BaseBee> bees = new ArrayList<>();

    @Override
    public void bury(int enemyIndex) {
        bees.remove(enemyIndex);
    }

    @Override
    public void hit(int enemyIndex) {
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
