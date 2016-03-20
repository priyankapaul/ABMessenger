package com.abmessenger.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abmessenger.R;

import java.util.ArrayList;

/**
 * Created by PRIYANKA on 3/2/2016.
 */
public class BizFriendAdapter extends RecyclerView.Adapter<BizFriendsViewHolder>{
    ArrayList<String> friendList;

    public BizFriendAdapter(ArrayList<String> friendList) {
        this.friendList = friendList;
    }

    @Override
    public BizFriendsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.biz_friends_list_item, parent, false);
        BizFriendsViewHolder bizFriendsViewHolder = new BizFriendsViewHolder(view);
        return bizFriendsViewHolder;
    }

    @Override
    public void onBindViewHolder(BizFriendsViewHolder holder, int position) {
        holder.ivBizImages.setImageResource(R.drawable.user_icon);
        holder.tvBizFriends.setText(friendList.get(position));
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }
}

class BizFriendsViewHolder extends RecyclerView.ViewHolder{

    ImageView ivBizImages;
    TextView tvBizFriends;
    public BizFriendsViewHolder(View itemView) {
        super(itemView);
        ivBizImages= (ImageView) itemView.findViewById(R.id.iv_album_icon);
        tvBizFriends= (TextView) itemView.findViewById(R.id.tv_user);
    }
}