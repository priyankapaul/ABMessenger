package com.abmessenger.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.GridView;

import com.abmessenger.R;
import com.abmessenger.adapters.AdvertisementAdapter;
import com.abmessenger.adapters.ViewPagerAdapter;
import com.abmessenger.utils.UiUtil;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {
    RecyclerView rvAdvertisement;
    LinearLayoutManager llmAdvertisement;

    Timer timerAdvertisement;

    int cursor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        UiUtil.removeButtonTransformationMethod((ViewGroup) findViewById(R.id.rl_root_home));
        configureTabLayoutAndViewPager();
        configureAdvertisementView();
    }


    @Override
    protected void onStart() {
        super.onStart();
        startTimer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopTimer();
    }

    public ArrayList<Integer> getResourceIdsOfAdvImages() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.admob_1);
        list.add(R.drawable.admob_2);
        list.add(R.drawable.admob_3);
        list.add(R.drawable.admob_4);
        list.add(R.drawable.admob_5);
        list.add(R.drawable.admob_6);

        return list;
    }


    private void configureAdvertisementView() {
        rvAdvertisement = (RecyclerView) findViewById(R.id.rv_adverisement);
        rvAdvertisement.setAdapter(new AdvertisementAdapter(getResourceIdsOfAdvImages()));

        rvAdvertisement.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    cursor = llmAdvertisement.findLastVisibleItemPosition();
                }
            }
        });
        llmAdvertisement = new LinearLayoutManager(HomeActivity.this);
        llmAdvertisement.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvAdvertisement.setLayoutManager(llmAdvertisement);
    }

       private void configureTabLayoutAndViewPager() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("User Update"));
        tabLayout.addTab(tabLayout.newTab().setText("Diary"));
        tabLayout.addTab(tabLayout.newTab().setText("Chat Box"));
        tabLayout.addTab(tabLayout.newTab().setText("Business Advertisement"));
        tabLayout.addTab(tabLayout.newTab().setText("Business Friends"));
        tabLayout.addTab(tabLayout.newTab().setText("Profile"));
        tabLayout.addTab(tabLayout.newTab().setText("Games"));
        tabLayout.addTab(tabLayout.newTab().setText("Mail"));
        tabLayout.addTab(tabLayout.newTab().setText("Albums"));
        tabLayout.addTab(tabLayout.newTab().setText("Account"));

        // Set up ViewPager
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final ViewPagerAdapter adapter = new ViewPagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void startTimer() {
        int itemCountOfAdvertisements = rvAdvertisement.getAdapter().getItemCount();

        timerAdvertisement = new Timer();


        timerAdvertisement.schedule(new AdvertisementTimerTask(itemCountOfAdvertisements), 0, 2 * 1000);
    }

        private void stopTimer() {

        if (timerAdvertisement != null) {
            timerAdvertisement.cancel();
        }
    }


    class AdvertisementTimerTask extends TimerTask {


        final int count;

        public AdvertisementTimerTask(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            if (cursor < count) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        rvAdvertisement.scrollToPosition(cursor);
                        cursor++;
                    }
                });
            }


            if (cursor >= count) {
                cursor = 0;
            }
        }
    }
}
