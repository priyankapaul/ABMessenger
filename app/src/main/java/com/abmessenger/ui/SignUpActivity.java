package com.abmessenger.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abmessenger.R;
import com.abmessenger.utils.UiUtil;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        UiUtil.removeButtonTransformationMethod((ViewGroup) findViewById(R.id.rl_root_signup));
    }
}
