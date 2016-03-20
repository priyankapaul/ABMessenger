

package com.abmessenger.ui.TabFragments;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.abmessenger.R;
import com.abmessenger.ui.BizPlanningActivity;
import com.abmessenger.ui.BizRuleActivity;
import com.abmessenger.ui.HelpActivity;
import com.abmessenger.ui.PriceActivity;
import com.abmessenger.ui.StartBizActivity;


public class TabFragmentBizAdvertisement extends Fragment {

    public TabFragmentBizAdvertisement() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_biz_advertisement, container, false);

        /**
         * Creating all buttons instances
         * */
        Button btn_biz_panning = (Button) rootView.findViewById(R.id.btn_biz_planning);

        Button btn_price = (Button) rootView.findViewById(R.id.btn_price);

        Button btn_biz_rule = (Button) rootView.findViewById(R.id.btn_biz_rule);


        Button btn_help = (Button) rootView.findViewById(R.id.btn_help);

//        Button btn_start_biz = (Button) rootView.findViewById(R.id.btn_start_biz);


        /**
         * Handling all button click events
         * */


        btn_biz_panning.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching Price Screen
                Intent i = new Intent(getActivity(), BizPlanningActivity.class);
                startActivity(i);
            }
        });

        btn_price.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching BizRule Screen
                Intent i = new Intent(getActivity(), PriceActivity.class);
                startActivity(i);
            }
        });

        btn_biz_rule.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching BizPlanning Screen
                Intent i = new Intent(getActivity(), BizRuleActivity.class);
                startActivity(i);
            }
        });

        btn_help.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching Help Screen
                Intent i = new Intent(getActivity(), HelpActivity.class);
                startActivity(i);
            }
        });

//        btn_start_biz.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                // Launching StartBiz Screen
//                Intent i = new Intent(getActivity(), StartBizActivity.class);
//                startActivity(i);
//            }
//        });

        return rootView;
    }
}
