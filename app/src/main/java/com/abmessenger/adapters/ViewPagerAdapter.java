package com.abmessenger.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.abmessenger.ui.TabFragments.TabFragmentAccounts;
import com.abmessenger.ui.TabFragments.TabFragmentAlbums;
import com.abmessenger.ui.TabFragments.TabFragmentBizAdvertisement;
import com.abmessenger.ui.TabFragments.TabFragmentBizFriends;
import com.abmessenger.ui.TabFragments.TabFragmentChatBox;
import com.abmessenger.ui.TabFragments.TabFragmentDiary;
import com.abmessenger.ui.TabFragments.TabFragmentGames;
import com.abmessenger.ui.TabFragments.TabFragmentMail;
import com.abmessenger.ui.TabFragments.TabFragmentProfile;
import com.abmessenger.ui.TabFragments.TabFragmentUserUpdate;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragmentUserUpdate tabFragmentUserUpdate = new TabFragmentUserUpdate();
                return tabFragmentUserUpdate;
            case 1:
                TabFragmentDiary tabFragmentDiary = new TabFragmentDiary();
                return tabFragmentDiary;
            case 2:
                TabFragmentChatBox tabFragmentChatBox = new TabFragmentChatBox();
                return tabFragmentChatBox;
            case 3:
                TabFragmentBizAdvertisement tabFragmentBizAdvertisement = new TabFragmentBizAdvertisement();
                return tabFragmentBizAdvertisement;
            case 4:
                TabFragmentBizFriends tabFragmentBizFriends = new TabFragmentBizFriends();
                return tabFragmentBizFriends;
            case 5:
                TabFragmentProfile tabFragmentProfile = new TabFragmentProfile();
                return tabFragmentProfile;
            case 6:
                TabFragmentGames tabFragmentGames = new TabFragmentGames();
                return tabFragmentGames;
            case 7:
                TabFragmentMail tabFragmentMail = new TabFragmentMail();
                return tabFragmentMail;
            case 8:
                TabFragmentAlbums tabFragmentAlbums = new TabFragmentAlbums();
                return tabFragmentAlbums;
            case 9:
                TabFragmentAccounts tabFragmentAccounts = new TabFragmentAccounts();
                return tabFragmentAccounts;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
