package com.osornet.estudioandroidudemy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    //views
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mapViews();
        showEmail(); // mostramos el email
    }

    /**
     * mapeo de views de la activity
     */
    private  void mapViews(){
        this.tvEmail = findViewById(R.id.tvEmail);
    }

    /**
     * muestra el email que se obtiene en el login
     */
    private void showEmail(){
        String email;
        Bundle extras;

        //obtenermos el conjunto de extras que se envian en le intent del login
        extras = getIntent().getExtras();
        //obtenemos el email
        email = extras.getString(MainActivity.EMAIL_LOGIN_KEY, "");
        //si no esta vacio el email editamo el evEmail.
        if(!email.isEmpty()){
            email = "Bienvenido: ".concat(email);
            this.tvEmail.setText(email);
        }

    }
}
