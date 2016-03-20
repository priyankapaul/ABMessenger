package com.abmessenger.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abmessenger.R;

import java.util.ArrayList;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineViewHolder> {
    ArrayList<String> posts;

    public TimelineAdapter(ArrayList<String> posts) {
        this.posts = posts;
    }

    @Override
    public TimelineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.timeline_list_item, parent, false);
        TimelineViewHolder timelineViewHolder = new TimelineViewHolder(view);
        return timelineViewHolder;
    }


    @Override
    public void onBindViewHolder(TimelineViewHolder holder, int position) {
        holder.tvTitle.setText(posts.get(position));

        if (position == 0)
            holder.ivPostImg.setImageResource(R.drawable.kiddo);
        else if (position % 3 == 0)
            holder.ivPostImg.setImageResource(R.drawable.fighter_plane_1);
        else if (position % 2 == 0)
            holder.ivPostImg.setImageResource(R.drawable.fighter_plane_2);
        else
            holder.ivPostImg.setImageResource(R.drawable.fighter_plane_3);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}

class TimelineViewHolder extends RecyclerView.ViewHolder {
    ImageView ivAvatar;
    TextView tvTitle;
    TextView tvDateTime;
    ImageView ivPostImg;

    public TimelineViewHolder(View itemView) {
        super(itemView);
        ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        tvDateTime = (TextView) itemView.findViewById(R.id.tv_date_time);
        ivPostImg = (ImageView) itemView.findViewById(R.id.iv_post_img);
    }

     }

