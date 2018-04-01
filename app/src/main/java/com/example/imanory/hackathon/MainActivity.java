package com.example.imanory.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"",Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Muneerah Toast Message", Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"jana",Toast.LENGTH_LONG).show();
    }
}
