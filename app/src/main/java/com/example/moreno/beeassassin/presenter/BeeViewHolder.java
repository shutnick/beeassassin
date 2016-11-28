package com.example.moreno.beeassassin.presenter;

import android.animation.Animator;
import android.graphics.Color;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moreno.beeassassin.R;

/**
 * Created by sso on 11/28/16.
 */

public class BeeViewHolder implements IBeeViewHolder{

    ImageView beeIcon;
    ImageView beeOverlay;
    TextView beeHealth;
    View beeHealthBg;

    public BeeViewHolder(View itemView) {
        beeIcon = (ImageView) itemView.findViewById(R.id.bee_icon);
        beeOverlay = (ImageView) itemView.findViewById(R.id.bee_overlay);
        beeHealth = (TextView) itemView.findViewById(R.id.bee_health_progress);
        beeHealthBg = itemView.findViewById(R.id.bee_health_status);
    }

    @Override
    public void animateHit(final boolean lastHit) {
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
                        if (lastHit) {
                            beeOverlay.setImageResource(R.drawable.cross_icon);
                        } else {
                            beeOverlay.setImageDrawable(null);
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

    @Override
    public void setHealthProgress(int currentHp, int maxHp) {
        beeHealth.setText(currentHp + "/" + maxHp);
    }

    @Override
    public void setHealthStatusColor(float healthFactor) {
        if (healthFactor == 1.f) {
            beeHealthBg.setBackgroundColor(Color.BLUE);
        } else if (healthFactor > .2F) {
            beeHealthBg.setBackgroundColor(Color.GREEN);
        } else {
            beeHealthBg.setBackgroundColor(Color.RED);
        }

    }
}
