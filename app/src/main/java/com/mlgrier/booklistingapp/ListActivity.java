package com.mlgrier.booklistingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String userBookSearchInfo = getIntent().getStringExtra("userBook2");

        Toast.makeText(getApplicationContext(), userBookSearchInfo, Toast.LENGTH_LONG).show();
    }
}
