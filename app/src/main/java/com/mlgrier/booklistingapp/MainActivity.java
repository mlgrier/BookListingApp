package com.mlgrier.booklistingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.getListBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userInput = (EditText) findViewById(R.id.bookKeyword);
                String userBookSearch = userInput.getText().toString();
                Toast.makeText(getApplicationContext(), (userBookSearch), Toast.LENGTH_LONG).show();
            }
        });

    }

}
