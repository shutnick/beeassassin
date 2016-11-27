package com.example.moreno.beeassassin.stubs;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.presenter.IGamePresenter;
import com.example.moreno.beeassassin.view.IViewCallback;

/**
 * Created on 26.11.2016.
 */
public class StubGamePresenter implements IGamePresenter {
    @Override
    public void hit() {

    }

    @Override
    public void finish() {

    }

    @Override
    public void onDamageDealt(BaseBee bee, int enemyIndex) {

    }

    @Override
    public void restoreProgress() {

    }

    @Override
    public void onCreate(IViewCallback viewCallback) {

    }

    @Override
    public void onDestroy() {

    }
}
