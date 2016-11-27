package com.example.moreno.beeassassin.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created on 27.11.2016.
 */

public class PresenterStateSaver extends Fragment {
    public static final String TAG = PresenterStateSaver.class.getSimpleName();
    private IGamePresenter gamePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public IGamePresenter getGamePresenter() {
        return gamePresenter;
    }

    public void setGamePresenter(IGamePresenter gamePresenter) {
        this.gamePresenter = gamePresenter;
    }
}
