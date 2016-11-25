package com.example.moreno.beeassassin.util;

import android.support.annotation.NonNull;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.model.Drone;
import com.example.moreno.beeassassin.model.Queen;
import com.example.moreno.beeassassin.model.Worker;

import java.util.ArrayList;

/**
 * Created by sso on 11/25/16.
 */

public class BeeGenerator {
    @NonNull
    public static ArrayList<BaseBee> createBees(int queensAmount, int workersAmount, int dronesAmount) {
        ArrayList<BaseBee> bees = new ArrayList<>();

        for (int i = 0; i < queensAmount; i++) {
            bees.add(new Queen());
        }

        for (int i = 0; i < workersAmount; i++) {
            bees.add(new Worker());
        }

        for (int i = 0; i < dronesAmount; i++) {
            bees.add(new Drone());
        }

        return bees;
    }
}
