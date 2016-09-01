package com.mlgrier.booklistingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connecting the button to collect input info on click
        final Button button = (Button) findViewById(R.id.getListBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //collecting the book keyword search here and putting it in userInput
                EditText userInput = (EditText) findViewById(R.id.bookKeyword);
                //storing the text in a string called userBookSearch
                String userBookSearch = userInput.getText().toString();
                //Starting up the op to switch over to the ListActivity on the,
                //button click
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                //sending the userBookSearch to the new ListActivity as userBook2
                i.putExtra("userBook2", userBookSearch);
                //starting up the ListActivity
                startActivity(i);
            }
        });

    }

}
