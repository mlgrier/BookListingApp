package com.mlgrier.booklistingapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //collecting the user entered information and storing it,
        //to be used in this activity as userBookSearchInfo
        Intent intent = getIntent();
        String userBookSearchInfo = intent.getStringExtra("userBook2");

        // Create a fake list of earthquakes.
        ArrayList<Book> books = QueryUtils.extractBookList();

        // Find a reference to the {@link ListView} in the layout
        ListView bookListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        final BookAdapter adapter = new BookAdapter(ListActivity.this, books);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        bookListView.setAdapter(adapter);

        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //find the current earthquake that was clicked on
                Book currentBook = adapter.getItem(position);

                //convert the string URL into a URI object (to pass into the intent constructor)
                Uri earthquakeUri = Uri.parse(currentBook.getUrl());

                //create a new intent to view that earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                //send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
    }


}
