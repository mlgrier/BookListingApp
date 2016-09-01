package com.mlgrier.booklistingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //collecting the user entered information and storing it,
        //to be used in this activity as userBookSearchInfo
        Intent intent = getIntent();
        String userBookSearchInfo = intent.getStringExtra("userBook2");

        Toast.makeText(getApplicationContext(), userBookSearchInfo, Toast.LENGTH_LONG).show();
    }
}
