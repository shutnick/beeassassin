package com.example.moreno.beeassassin.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.moreno.beeassassin.R;
import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.BeeType;

/**
 * Created on 26.11.2016.
 */

public class BeeView extends RelativeLayout {

    public static final int BASE_WIDTH = 80;
    public static final int BASE_ICONS_HEIGHT = 80;
    public static final int BASE_BAR_HEIGHT = 30;
    private final BeeType beeType;

    private int viewWidth;
    private int imageHeight;
    private int barsHeight;
    private float scaleFactor;
    private View healthStatus;
    private TextView healthProgress;
    private ImageView beeOverlay;
    private View beeIcon;

    public BeeView(Context context, BeeType beeType) {
        super(context);
        this.beeType = beeType;
        initDimens();
        initViews();
    }

    private void initDimens() {
        switch (beeType) {
            case QUEEN:
                scaleFactor = 1.5F;
                break;
            case WORKER:
                scaleFactor = 1.25F;
                break;
            case DRONE:
            default:
                scaleFactor = 1.F;
                break;
        }
        viewWidth = (int)(BASE_WIDTH * scaleFactor);
        imageHeight = (int)(BASE_ICONS_HEIGHT * scaleFactor);
        barsHeight = (int)(BASE_BAR_HEIGHT * scaleFactor);
    }

    private void initViews() {
        initRoot();
        initBeeIcon();
        initBeeOverlay();
        initHealthBar();
        initHealthProgress();
    }

    private void initBeeOverlay() {
        beeOverlay = (ImageView) getChildAt(1);
        beeOverlay.setLayoutParams(new LayoutParams(viewWidth, imageHeight));
    }

    private void initHealthProgress() {
        healthProgress = (TextView) getChildAt(3);
        final LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(ALIGN_BOTTOM, healthStatus.getId());
        params.addRule(CENTER_HORIZONTAL);

        healthProgress.setLayoutParams(params);
        int beeHealth = beeType.getFullHp();
        healthProgress.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        healthProgress.setText(beeHealth + "/" + beeHealth);
        healthProgress.setTextColor(Color.WHITE);
    }

    private void initHealthBar() {
        healthStatus = getChildAt(2);
        final LayoutParams params = new LayoutParams(viewWidth, barsHeight);
        params.addRule(BELOW, beeIcon.getId());
        params.leftMargin = 2;
        params.rightMargin = 2;
        healthStatus.setLayoutParams(params);
        healthStatus.setBackgroundColor(Color.BLUE);
    }

    private void initBeeIcon() {
        beeIcon = getChildAt(0);
        beeIcon.setLayoutParams(new LayoutParams(viewWidth, viewWidth));
    }

    private void initRoot() {
        final LayoutParams params = new LayoutParams(viewWidth, imageHeight + barsHeight);
        params.topMargin = 5;
        setLayoutParams(params);
        LayoutInflater.from(getContext()).inflate(R.layout.bee_view, this, true);
    }


    public void refresh(final BaseBee bee) {
        beeOverlay.animate()
                .setInterpolator(new DecelerateInterpolator())
                .setDuration(200)
                .alpha(1.F)
                .setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                beeOverlay.setImageResource(R.drawable.pow_icon);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                beeOverlay.setImageDrawable(null);
                final int currentHealth = bee.getCurrentHealth() > 0 ? bee.getCurrentHealth() : 0;
                healthProgress.setText(currentHealth + "/" + bee.getFullHP());
                int healthFactor = bee.getFullHP() / bee.getCurrentHealth();
                if (healthFactor >= 4) {
                    healthStatus.setBackgroundColor(Color.RED);
                } else if (healthFactor >= 1) {
                    healthStatus.setBackgroundColor(Color.GREEN);
                }

                if (bee.isDead()) {
                    beeOverlay.setImageResource(R.drawable.cross_icon);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();

    }
}
