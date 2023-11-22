package com.example.colmeiaofc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.colmeiaofc.R;
import com.example.colmeiaofc.contatos;
import com.example.colmeiaofc.model.Usuário;
import com.example.colmeiaofc.útil.ConfiguraBd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText campoEmail, campoSenha;
    Button botaoAcessar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        auth = ConfiguraBd.Firebaseauth();
        inicializarComponentes();
    }

    public void validarAutenticacao(View view){

        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();

        if(!email.isEmpty()){
            if(!senha.isEmpty()){

                Usuário usuario = new Usuário();

                usuario.setEmail(email);
                usuario.setSenha(senha);

                logar(usuario);


            }else{
                Toast.makeText(this, "Preencha a Senha", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Preencha o Email", Toast.LENGTH_SHORT).show();
        }
    }

    private void logar(Usuário usuario) {

        auth.signInWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    abrirWelcomeScreen();
                }else{
                    String excecao="";
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e){
                        excecao = "Usuário não está cadastrado";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        excecao = "Email ou Senha Incorreto";
                    }catch (Exception e){
                        excecao = "Erro ao Logar o usuário"+e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(LoginActivity.this, excecao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void abrirWelcomeScreen() {
        Intent i = new Intent(LoginActivity.this, WelcomeScreen.class);
        startActivity(i);
    }


    public void cadastrar(View view){
        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
    }


    protected void onStart(){
    super.onStart();
        FirebaseUser usuarioAuth = auth.getCurrentUser();
        if(usuarioAuth !=null){
            abrirWelcomeScreen();
        }
    }




    private void inicializarComponentes(){
        campoEmail = findViewById(R.id.editTextEmailLogin);
        campoSenha = findViewById(R.id.editTextSenhaLogin);
        botaoAcessar = findViewById(R.id.buttonAcessarLogin);
    }

}