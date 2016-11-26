package com.example.moreno.beeassassin.view;

import com.example.moreno.beeassassin.model.BaseBee;

/**
 * Created on 26.11.2016.
 */

public interface IBeeCallback {
    void onBeeHit(BaseBee bee, int beeIndex);
}
