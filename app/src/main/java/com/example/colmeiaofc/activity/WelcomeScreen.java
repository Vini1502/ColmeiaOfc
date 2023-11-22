package com.example.colmeiaofc.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.colmeiaofc.R;
import com.google.firebase.auth.FirebaseAuth;

public class WelcomeScreen extends AppCompatActivity {

    private ImageButton buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        buttonLogout = findViewById(R.id.buttonLogout);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Desconecta do Firebase Auth
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(WelcomeScreen.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    public void TelaTarde(View view) {
        Intent in = new Intent(WelcomeScreen.this, TelaTarde.class);
        startActivity(in);
    }

    public void TelaNoite(View view) {
        Intent inn = new Intent(WelcomeScreen.this, TelaNoite.class);
        startActivity(inn);
    }

    public void Contatos(View view) {
        Intent inn = new Intent(WelcomeScreen.this, Contatos.class);
        startActivity(inn);
    }
}