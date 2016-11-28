package com.example.moreno.beeassassin.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.moreno.beeassassin.R;
import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.presenter.EnemiesAdapter;
import com.example.moreno.beeassassin.presenter.GamePresenter;
import com.example.moreno.beeassassin.presenter.IGamePresenter;
import com.example.moreno.beeassassin.presenter.PresenterStateSaver;

import java.util.List;

/**
 * Created on 23.11.2016.
 */

public class GameActivity extends FragmentActivity implements IViewCallback{
    private IGamePresenter gamePresenter;
    private View hitButton;
    private EnemiesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        final Fragment stateFragment = getSupportFragmentManager()
                .findFragmentByTag(PresenterStateSaver.TAG);
        if (stateFragment == null) {
            gamePresenter = new GamePresenter();
            gamePresenter.onCreate(this);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(new PresenterStateSaver(), PresenterStateSaver.TAG)
                    .commit();
        } else {
            gamePresenter = ((PresenterStateSaver) stateFragment).getGamePresenter();
            gamePresenter.onCreate(this);
        }
        adapter = gamePresenter.createAdapter();
        initViews();
    }

    @Override
    protected void onDestroy() {
        final Fragment stateFragment = getSupportFragmentManager()
                .findFragmentByTag(PresenterStateSaver.TAG);
        ((PresenterStateSaver) stateFragment).setGamePresenter(gamePresenter);
        gamePresenter.onDestroy();
        super.onDestroy();
    }

    private void initViews() {
        hitButton = findViewById(R.id.hit_button);
        hitButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                reinit();
                return true;
            }
        });

        LinearLayout queenLayer = (LinearLayout) findViewById(R.id.queens_container);
        LinearLayout workerLayer = (LinearLayout) findViewById(R.id.workers_container);
        LinearLayout droneLayer = (LinearLayout) findViewById(R.id.drones_container);

        for (BaseBee bee : adapter.getItems()) {
            BeeView view = new BeeView(this, bee.getType());
            adapter.bindView(view);

            switch (bee.getType()) {
                case QUEEN:
                    queenLayer.addView(view);
                    break;
                case WORKER:
                    workerLayer.addView(view);
                    break;
                case DRONE:
                    droneLayer.addView(view);
                    break;
            }
        }
    }

    private void reinit() {
        gamePresenter = new GamePresenter();
        initViews();
    }

    @Override
    public void refresh(int beeId) {
        adapter.onItemChanged(beeId);
    }

    @Override
    public void restoreViews(List<BaseBee> bees) {
        for (int i = 0; i < bees.size(); i++){
            refresh(i);
        }
    }

    @Override
    public void showFinish() {
        hitButton.setEnabled(false);
        final Snackbar snackbar = Snackbar.make(findViewById(R.id.root), "You're done!", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("Restart", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
                hitButton.setEnabled(true);
                reinit();
            }
        });
        snackbar.show();
    }

    public void hitBee(View hitButton) {
        gamePresenter.hit();
    }
}
