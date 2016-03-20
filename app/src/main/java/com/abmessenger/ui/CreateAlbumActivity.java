package com.abmessenger.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.abmessenger.R;

public class CreateAlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_album);

        setTitle("Create Album");
    }
}
