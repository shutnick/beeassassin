package com.example.moreno.beeassassin.view;

import com.example.moreno.beeassassin.model.BaseBee;

import java.util.List;

/**
 * Created by sso on 11/25/16.
 */

public interface IViewCallback {

    void refresh(int beeId);
    void restoreViews(List<BaseBee> bees);
    void showFinish();
}
