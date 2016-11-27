package com.example.moreno.beeassassin.view;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.BeeType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sso on 11/25/16.
 */

public interface IViewCallback {

    void refresh(BaseBee bee, int beeId);
    void restoreViews(List<BaseBee> bees);
}
