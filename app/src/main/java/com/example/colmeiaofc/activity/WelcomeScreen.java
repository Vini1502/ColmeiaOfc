package com.example.colmeiaofc.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.colmeiaofc.R;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }
    public void TelaTarde(View view){
        Intent in = new Intent(WelcomeScreen.this, TelaTarde.class);
        startActivity(in);
    }

    public void TelaNoite(View view){
        Intent inn = new Intent(WelcomeScreen.this, TelaNoite.class);
        startActivity(inn);
    }
}