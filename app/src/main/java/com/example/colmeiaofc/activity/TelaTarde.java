package com.example.colmeiaofc.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.colmeiaofc.R;

public class TelaTarde extends AppCompatActivity {


    private Button segunda;
    private Button terca;
    private Button quarta;
    private Button quinta;
    private Button sexta;
    private String aula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_tarde);

            segunda = (Button) findViewById(R.id.segundat);
            segunda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDialog("13:30-14:30         Química-A\n14:30-15:30          Física-A\n15:30-15:50           Intervalo\n15:50-16:50          Biologia-B\n16:50-17:50         Geopolítica\n\nBons Estudos ;)");
                }
            });

            terca = (Button) findViewById(R.id.terçat);

            terca.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDialog("13:30-14:30         História do Brasil\n14:30-15:30          Biologia-A\n15:30-15:50           Intervalo\n15:50-16:50          História Geral\n16:50-17:50         Sociologia\n\nBons Estudos ;)");

                }
            });

            quarta = (Button) findViewById(R.id.quartat);
            quarta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDialog("13:30-14:30         Literatura\n14:30-15:30          Física-B\n15:30-15:50           Intervalo\n15:50-16:50          Matemática-B\n16:50-17:50         Inglês\n\nBons Estudos ;)");

                }
            });

            quinta = (Button) findViewById(R.id.quintat);
            quinta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDialog("13:30-14:30         Química-B\n14:30-15:30          Redação\n15:30-15:50           Intervalo\n15:50-16:50          Matemática-A\n16:50-17:50         Sem aula\n\nBons Estudos ;)");

                }
            });

            sexta = (Button) findViewById(R.id.sexta);
            sexta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDialog("13:30-14:30         Geografia Geral\n14:30-15:30          Geografia do Brasil\n15:30-15:50           Intervalo\n15:50-16:50          Gramática\n16:50-17:50         Filosofia\n\nBons Estudos ;)");

                }
            });
        }
    private void openDialog (String aula){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.setAula(aula);
        exampleDialog.show(getSupportFragmentManager(), "example dialog");

    }
}