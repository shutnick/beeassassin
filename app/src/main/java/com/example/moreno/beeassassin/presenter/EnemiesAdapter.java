package com.example.moreno.beeassassin.presenter;

import com.example.moreno.beeassassin.model.BaseBee;
import com.example.moreno.beeassassin.view.BeeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sso on 11/28/16.
 */

public class EnemiesAdapter{
    private ArrayList<BaseBee> bees;
    private ArrayList<BeeViewHolder> holders;

    public EnemiesAdapter(List<BaseBee> bees) {
        this.bees = new ArrayList<>(bees);
        holders = new ArrayList<>(bees.size());
    }

    public void onItemChanged(int position) {
        BaseBee bee = bees.get(position);
        BeeViewHolder holder = holders.get(position);
        holder.animateHit(bee.isDead());
        holder.setHealthProgress(bee.getCurrentHealth(), bee.getType().getFullHp());
        holder.setHealthStatusColor(bee.getCurrentHealth() * 1.F / bee.getType().getFullHp());
    }

    public void bindView(BeeView view) {
        BeeViewHolder holder = new BeeViewHolder(view);
        holders.add(holder);
        onItemChanged(holders.size() - 1);
    }

    public List<BaseBee> getItems() {
        return bees;
    }

}
