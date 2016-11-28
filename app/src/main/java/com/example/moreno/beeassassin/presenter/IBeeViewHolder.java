package com.example.moreno.beeassassin.presenter;


/**
 * Created by sso on 11/28/16.
 */

public interface IBeeViewHolder{
    void animateHit(boolean lastHit);
    void setHealthProgress(int currentHp, int maxHp);
    void setHealthStatusColor(float healthFactor);
}
