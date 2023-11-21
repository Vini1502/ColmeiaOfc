package com.example.colmeiaofc.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.colmeiaofc.R;
import com.example.colmeiaofc.model.Usuário;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity { //é minha main

    Usuário usuario;
    FirebaseAuth autenticacao;
    EditText campoNome, campoEmail, campoSenha;
    Button botaoCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        inicializar();
        ///validar campos();
    }

    public void cadastrar(View v) {
        Intent incad = new Intent(this, LoginActivity.class);
        startActivity(incad);
    }

    private void inicializar(){
        campoNome = findViewById(R.id.editTextNome);
        campoEmail = findViewById(R.id.editTextEmail);
        campoSenha = findViewById(R.id.editTextSenha);
        botaoCadastrar = findViewById(R.id.buttonCadastrar);
    }
        private void validarCampos(View v) {
            String nome = campoNome.getText().toString();
            String email = campoEmail.getText().toString();
            String senha = campoSenha.getText().toString();


            if (!nome.isEmpty()){
                if (!email.isEmpty()) {
                    if(!senha.isEmpty()) {

                        Usuário usuario = new Usuário();

                        usuario.setNome(nome);
                        usuario.setEmail(email);
                        usuario.setSenha(senha);

                        //cadastro do usuário
                        cadastrarUsuario();

                    }else {
                        Toast.makeText(this, "Preencher a senha", Toast.LENGTH_SHORT).show();
                    }
                }else{
                        Toast.makeText(this, "Preencher o email", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Preencher o nome", Toast.LENGTH_SHORT).show();
                }
            }

    private void cadastrarUsuario() {
    }


}


