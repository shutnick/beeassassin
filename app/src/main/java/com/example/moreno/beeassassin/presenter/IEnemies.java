package com.example.moreno.beeassassin.presenter;

import com.example.moreno.beeassassin.model.BaseBee;

import java.util.List;

/**
 * Created on 23.11.2016.
 */

public interface IEnemies {
    void hit(int enemyIndex);
    int getAliveCount();
    void attachGamePresenter(IGamePresenter gamePresenter);
    List<BaseBee> getState();
}
