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
    private TextView mapsLink;

    private TextView faceLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);
        txtInstagramLink = findViewById(R.id.textInsta);
        mapsLink = findViewById(R.id.textMaps);
        faceLink = findViewById(R.id.textFace);
        faceLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String faceUrl = "https://www.facebook.com/cursinhocolmeiaindigena";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(faceUrl));
                startActivity(intent);
            }
        });

        mapsLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String mapsUrl = "https://maps.app.goo.gl/9PkimyFmk71aN7LbA";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapsUrl));
            startActivity(intent);
            }
        });

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
        //Muda cor da Status Bar
        getWindow().setStatusBarColor(getColor(R.color.black));
    }
}