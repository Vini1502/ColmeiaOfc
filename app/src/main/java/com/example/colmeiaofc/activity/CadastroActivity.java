package com.example.colmeiaofc.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.colmeiaofc.R;
import com.example.colmeiaofc.model.Usuario;
import com.example.colmeiaofc.útil.ConfiguraBd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity { //é minha main

    Usuario usuario;
    FirebaseAuth autenticacao;
    EditText campoNome, campoEmail, campoSenha;
    Button botaoCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);;

        inicializar();

        //mudando cor da barra
        getWindow().setStatusBarColor(getColor(R.color.black));
    }

    public void cadastrar(View v) {
        Intent incad = new Intent(this, LoginActivity.class);
        startActivity(incad);
    }

    private void inicializar(){
        campoNome = findViewById(R.id.editTextNome);
        campoEmail = findViewById(R.id.editTextEmailLogin);
        campoSenha = findViewById(R.id.editTextSenhaLogin);
        botaoCadastrar = findViewById(R.id.buttonCadastrar);
    }
        public void validarCampos(View v) {
            String nome = campoNome.getText().toString();
            String email = campoEmail.getText().toString();
            String senha = campoSenha.getText().toString();


            if (!nome.isEmpty()){
                if (!email.isEmpty()) {
                    if(!senha.isEmpty()) {

                        usuario = new Usuario();

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
                Toast.makeText(this, "Preencher o nome", Toast.LENGTH_SHORT).show();;
                }
            }

    private void cadastrarUsuario() {

        autenticacao = ConfiguraBd.Firebaseauth();

        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(CadastroActivity.this, "Sucesso ao Cadastrar o Usuário", Toast.LENGTH_SHORT).show();
                } else {
                    String excecao = "";

                    try{
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){  //exceção para senha muito fraca inserida pelo usuário
                        excecao = "Digite uma senha mais forte";
                    }catch (FirebaseAuthInvalidCredentialsException e){  //exceção para email inválido
                        excecao = "Digite um email válido";
                    }catch (FirebaseAuthUserCollisionException e){        //Usuário tentando cadastrar uma conta já existente
                        excecao = "Essa conta já existe";
                    }catch (Exception e){
                        excecao = "Erro ao cadastrar usuário" + e.getMessage();
                        e.printStackTrace();                                        //Trazer um log de erro
                    }
                    Toast.makeText(CadastroActivity.this, excecao, Toast.LENGTH_SHORT).show();
                }
            }
        });
        }

}


