package com.example.colmeiaofc.útil;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class usuarioAutenticado {

    public static FirebaseUser usuarioLogado(){
        FirebaseAuth usuario = ConfiguraBd.Firebaseauth();
        return usuario.getCurrentUser();
    }
}
