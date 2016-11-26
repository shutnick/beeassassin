package com.example.moreno.beeassassin.presenter;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.BeeType;

/**
 * Created on 23.11.2016.
 */

public interface IGamePresenter {
    void hit();
    void finish();
    void onDamageDealt(BaseBee bee, int enemyIndex);

}
