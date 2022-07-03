package com.example.careshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SpalshScreen extends AppCompatActivity {

    public void getStarted(View view){
        startActivity(new Intent(this , Personal_Info.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);
    }
}