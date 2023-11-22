package com.example.colmeiaofc.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.colmeiaofc.R;

public class TelaNoite extends AppCompatActivity {


    private Button segunda;
    private Button terca;
    private Button quarta;
    private Button quinta;
    private Button sexta;
    private String aula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_noite);

        segunda = (Button) findViewById(R.id.segundan);
        segunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog("18:00-19:00         Geopolítica\n19:00-20:00          História Geral\n20:00-20:20           Intervalo\n20:20-21:20          Química-A\n21:20-22:20         Geografia Geral\n\nBons Estudos ;)");
            }
        });

        terca = (Button) findViewById(R.id.terçan);

        terca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog("18:00-19:00         Sociologia\n19:00-20:00          Biologia-B\n20:00-20:20           Intervalo\n20:20-21:20          Geografia do Brasil\n21:20-22:20         Matemática-B\n\nBons Estudos ;)");

            }
        });

        quarta = (Button) findViewById(R.id.quartan);
        quarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog("18:00-19:00         Inglês\n19:00-20:00          Biologia-A\n20:00-20:20           Intervalo\n20:20-21:20          História do Brasil\n21:20-22:20         Química-B\n\nBons Estudos ;)");

            }
        });

        quinta = (Button) findViewById(R.id.quintan);
        quinta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog("18:00-19:00         Sem aula\n19:00-20:00          Literatura\n20:00-20:20           Intervalo\n20:20-21:20          Física-A\n21:20-22:20         Redação\n\nBons Estudos ;)");

            }
        });

        sexta = (Button) findViewById(R.id.sextan);
        sexta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog("18:00-19:00         Filosofia\n19:00-20:00          Matemática-A\n20:00-20:20           Intervalo\n20:20-21:20          Gramática\n21:20-22:20         Física-B\n\nBons Estudos ;)");

            }
        });
    }
    private void openDialog (String aula){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.setAula(aula);
        exampleDialog.show(getSupportFragmentManager(), "example dialog");

    }
}

