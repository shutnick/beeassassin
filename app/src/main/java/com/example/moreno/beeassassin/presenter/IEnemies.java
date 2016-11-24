package com.example.moreno.beeassassin.presenter;

/**
 * Created on 23.11.2016.
 */

public interface IEnemies {
    void bury(int enemyIndex);
    void hit(int enemyIndex);
    int getAliveCount();
}
