package com.example.moreno.beeassassin.view;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.BeeType;

/**
 * Created by sso on 11/25/16.
 */

public interface IViewCallback {

    void refresh(BaseBee bee, int beeId);
}
