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
import com.abmessenger.adapters.BizFriendAdapter;

import java.util.ArrayList;

public class TabFragmentBizFriends extends Fragment {

    public TabFragmentBizFriends() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_biz_friends, container, false);
        RecyclerView rvBizFriends = (RecyclerView) rootView.findViewById(R.id.rv_biz_friends);
        rvBizFriends.setAdapter(new BizFriendAdapter(getDummyFriends()));
        rvBizFriends.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }
    /**
     * Populate dummy friends
     */
    public ArrayList<String> getDummyFriends() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Friend Name " + i);
        }
        return list;
    }
}

