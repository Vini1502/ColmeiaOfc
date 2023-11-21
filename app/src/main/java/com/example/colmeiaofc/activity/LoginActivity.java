package com.example.colmeiaofc.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.colmeiaofc.R;

public class LoginActivity extends AppCompatActivity {
    private SQLiteDatabase bancoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

    }

    public void cadastrar(View view) {
        Intent cad = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(cad);
    }
}
