package com.abmessenger.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abmessenger.R;
import com.abmessenger.model.Album;

import java.util.ArrayList;

/**
 * Created by PRIYANKA on 3/7/2016.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumViewHolder> {

    ArrayList<Album> albums;

    public AlbumAdapter(ArrayList<Album> albums) {
        this.albums = albums;
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.advertisement_list_item, parent, false);
        AlbumViewHolder albumViewHolder = new AlbumViewHolder(view);
        return albumViewHolder;
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        // Get the album object at index position
        Album album = albums.get(position);

        // ivALbumIcon for now will be set in xml or layout itself
//        holder.ivAlbumIcon.setImageResource(albums.get(position));
        holder.tvAlbumTitle.setText(album.getTitle());
        holder.tvAlbumSubTitle.setText(album.getSubTitle());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }
}

class AlbumViewHolder extends RecyclerView.ViewHolder {
    ImageView ivAlbumIcon;
    TextView tvAlbumTitle;
    TextView tvAlbumSubTitle;

    public AlbumViewHolder(View itemView) {
        super(itemView);
        ivAlbumIcon = (ImageView) itemView.findViewById(R.id.iv_slide_adv);
        tvAlbumTitle = (TextView) itemView.findViewById(R.id.tv_albumb_title);
        tvAlbumSubTitle = (TextView) itemView.findViewById(R.id.tv_albumb_sub_title);
    }
}