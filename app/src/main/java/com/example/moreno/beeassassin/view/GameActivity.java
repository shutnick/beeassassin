package com.example.moreno.beeassassin.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.moreno.beeassassin.R;
import com.example.moreno.beeassassin.config.EnemiesConfig;
import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.presenter.EnemiesPresenter;
import com.example.moreno.beeassassin.presenter.GamePresenter;
import com.example.moreno.beeassassin.presenter.IGamePresenter;
import com.example.moreno.beeassassin.util.BeeGenerator;

import java.util.ArrayList;

/**
 * Created on 23.11.2016.
 */

public class GameActivity extends Activity implements IViewCallback{
    private IGamePresenter gamePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        initViews();
        ArrayList<BaseBee> enemies = BeeGenerator.createBees(
                EnemiesConfig.QUEENS_AMOUNT,
                EnemiesConfig.WORKERS_AMOUNT,
                EnemiesConfig.DRONES_AMOUNT);
        EnemiesPresenter enemiesPresenter = new EnemiesPresenter(enemies);

        gamePresenter = new GamePresenter(enemiesPresenter);
    }

    private void initViews() {
        initBeeLayer((LinearLayout) findViewById(R.id.queens_container), EnemiesConfig.QUEENS_AMOUNT);
        initBeeLayer((LinearLayout) findViewById(R.id.workers_container), EnemiesConfig.WORKERS_AMOUNT);
        initBeeLayer((LinearLayout) findViewById(R.id.drones_container), EnemiesConfig.DRONES_AMOUNT);
    }

    private void initBeeLayer(LinearLayout container, int amount) {
        for (int i = 0; i < amount; i++) {
            ImageView view = new ImageView(this);
            view.setImageResource(R.drawable.angry_bee);
            view.setLayoutParams(new ViewGroup.LayoutParams(50, 50));
            container.addView(view);
        }
    }

    @Override
    public void refresh() {

    }

    public void hitBee() {

    }
}
