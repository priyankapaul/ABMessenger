package com.abmessenger.ui.TabFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abmessenger.R;
import com.abmessenger.adapters.TimelineAdapter;

import java.util.ArrayList;

public class TabFragmentUserUpdate extends Fragment {

    public TabFragmentUserUpdate() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_user_update, container, false);
        RecyclerView rvTimeline = (RecyclerView) rootView.findViewById(R.id.rv_user_timeline);
        rvTimeline.setAdapter(new TimelineAdapter(getDummyPosts()));
        rvTimeline.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }

    /**
     * Populate dummy notes
     */
    public ArrayList<String> getDummyPosts() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Person Name " + i);
        }
        return list;
    }
}
