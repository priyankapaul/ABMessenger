package com.abmessenger.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.abmessenger.R;

import java.io.File;


public class ViewImageActivity extends AppCompatActivity {
    ImageView iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

      //  Intent i=getIntent();
       // File f= (File) i.getExtras().getParcelable("img");
        String f=getIntent().getStringExtra("img");
        iv2= (ImageView) findViewById(R.id.imageView3);
        iv2.setImageURI(Uri.parse(f));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
