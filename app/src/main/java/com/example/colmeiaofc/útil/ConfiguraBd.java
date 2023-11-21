package com.example.colmeiaofc.útil;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;

public class ConfiguraBd {

    private static FirebaseAuth auth;

    public static FirebaseAuth Firebaseauth(){
        if(auth ==null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }
}
