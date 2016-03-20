package com.abmessenger.ui.TabFragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abmessenger.R;
import com.abmessenger.adapters.AlbumAdapter;
import com.abmessenger.model.Album;
import com.abmessenger.ui.CreateAlbumActivity;

import java.util.ArrayList;

public class TabFragmentAlbums extends Fragment {
    private static final int REQ_CODE_CREATE_ALBUM = 1111;

    AlbumAdapter albumAdapter;
    FloatingActionButton fabCreateAlbum;

    public TabFragmentAlbums() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_albums, container, false);

        RecyclerView rvAlbum = (RecyclerView) rootView.findViewById(R.id.rv_album);
        fabCreateAlbum = (FloatingActionButton) rootView.findViewById(R.id.fab_create_album);

        fabCreateAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateAlbumActivity.class);
                startActivityForResult(intent, REQ_CODE_CREATE_ALBUM);
            }
        });
        // configure recycler view
        albumAdapter = new AlbumAdapter(getDummyAlbums());
        rvAlbum.setAdapter(albumAdapter);
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE_CREATE_ALBUM) {
            if (resultCode == Activity.RESULT_OK) {
//                Album album = data.getParcelableExtra(Album.EXTRA_ALBUM);
            }
        }
    }

        private ArrayList<Album> getDummyAlbums() {
        ArrayList<Album> albums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Album album = new Album("Title-" + i, "SubTitle-" + i);
            albums.add(album);
        }
        return albums;
    }
}
