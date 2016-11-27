package com.example.moreno.beeassassin.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.moreno.beeassassin.R;
import com.example.moreno.beeassassin.config.EnemiesConfig;
import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.BeeType;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        initViews();

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
            gamePresenter.restoreProgress();
        }
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
        initBeeLayer((LinearLayout) findViewById(R.id.queens_container), BeeType.QUEEN, EnemiesConfig.QUEENS_AMOUNT);
        initBeeLayer((LinearLayout) findViewById(R.id.workers_container), BeeType.WORKER, EnemiesConfig.WORKERS_AMOUNT);
        initBeeLayer((LinearLayout) findViewById(R.id.drones_container), BeeType.DRONE, EnemiesConfig.DRONES_AMOUNT);
    }

    private void reinit() {
        initViews();
        gamePresenter = new GamePresenter();
    }

    private void initBeeLayer(LinearLayout container, BeeType type, int amount) {
        container.removeAllViews();
        for (int i = 0; i < amount; i++) {
            container.addView(new BeeView(this, type));
        }
    }

    @Override
    public void refresh(BaseBee bee, int beeId) {
        BeeView target = getBeeViewById(bee, beeId);
        target.refresh(bee);

        if (bee.getType() == BeeType.QUEEN && bee.isDead()) {
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

    }

    @Override
    public void restoreViews(List<BaseBee> bees) {
        for (int i = 0; i < bees.size(); i++){
            refresh(bees.get(i), i);
        }
    }

    private BeeView getBeeViewById(BaseBee bee, int beeId) {
        BeeView target;
        switch (bee.getType()) {
            case QUEEN:
                target = (BeeView) ((LinearLayout) findViewById(R.id.queens_container)).getChildAt(beeId);
                break;
            case WORKER:
                target = (BeeView) ((LinearLayout) findViewById(R.id.workers_container)).getChildAt(beeId - EnemiesConfig.QUEENS_AMOUNT);
                break;
            case DRONE:
            default:
                target = (BeeView) ((LinearLayout) findViewById(R.id.drones_container)).getChildAt(beeId - EnemiesConfig.QUEENS_AMOUNT - EnemiesConfig.WORKERS_AMOUNT);
                break;
        }
        return target;
    }

    public void hitBee(View hitButton) {
        gamePresenter.hit();
    }
}
