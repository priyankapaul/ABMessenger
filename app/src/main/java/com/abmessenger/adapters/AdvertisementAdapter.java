package com.abmessenger.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.abmessenger.R;

import java.util.ArrayList;

public class AdvertisementAdapter extends RecyclerView.Adapter<AdvertisementViewHolder> {

    ArrayList<Integer> resourceIds;

    public AdvertisementAdapter(ArrayList<Integer> resourceIds) {
        this.resourceIds = resourceIds;
    }

    @Override
    public AdvertisementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.advertisement_list_item, parent, false);
        AdvertisementViewHolder advViewHolder = new AdvertisementViewHolder(view);
        return advViewHolder;
    }

    @Override
    public void onBindViewHolder(AdvertisementViewHolder holder, int position) {
        holder.ivSlideAdv.setImageResource(resourceIds.get(position));
    }

    @Override
    public int getItemCount() {
        return resourceIds.size();
    }
}

class AdvertisementViewHolder extends RecyclerView.ViewHolder {
    ImageView ivSlideAdv;

    public AdvertisementViewHolder(View itemView) {
        super(itemView);
        ivSlideAdv = (ImageView) itemView.findViewById(R.id.iv_slide_adv);
    }
}