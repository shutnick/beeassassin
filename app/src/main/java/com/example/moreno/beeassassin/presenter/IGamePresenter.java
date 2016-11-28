package com.example.moreno.beeassassin.presenter;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.BeeType;
import com.example.moreno.beeassassin.view.IViewCallback;

/**
 * Created on 23.11.2016.
 */

public interface IGamePresenter {
    void hit();
    void onDamageDealt(BaseBee bee, int enemyIndex);
    void restoreProgress();
    void onCreate(IViewCallback viewCallback);
    void onDestroy();
}
