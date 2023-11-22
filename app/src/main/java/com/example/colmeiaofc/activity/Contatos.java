package com.example.colmeiaofc.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.colmeiaofc.R;

public class Contatos extends AppCompatActivity {

    private TextView txtInstagramLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);
        txtInstagramLink = findViewById(R.id.textInsta);

        // Adiciona um ouvinte de clique ao texto do Instagram
        txtInstagramLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Abre o perfil do Instagram no navegador
                String instagramUrl = "https://www.instagram.com/cursinhocolmeia/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));
                startActivity(intent);
            }
        });
    }
}