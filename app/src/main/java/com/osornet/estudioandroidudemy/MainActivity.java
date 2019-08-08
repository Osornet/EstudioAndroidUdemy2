package com.osornet.estudioandroidudemy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //views
    private EditText evEmail, etPass;
    private String email, pass;

    //keys
    public static final String EMAIL_LOGIN_KEY = "EMAIL_LOGIN_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapViews();
    }

    /**
     * mapeo de views de la activity
     */
    private void mapViews(){
        this.evEmail = findViewById(R.id.etEmail);
        this.etPass = findViewById(R.id.etPass);
    }

    /**
     * valida si los campos del login (email y pass)sean vacios
     * @return TRUE si son vacios, FALSE si no son vacios
     */
    private boolean isCamposVacios(){
        final String MSG_ERR_VOID = "campo vacio";
        boolean isCamposVacios = false;

        this.email = this.evEmail.getText().toString();
        this.pass = this.etPass.getText().toString();

        if(email != null && email.isEmpty()){
            evEmail.setError(MSG_ERR_VOID);
            isCamposVacios = true;
        }

        if(pass != null && pass.isEmpty()){
            etPass.setError(MSG_ERR_VOID);
            isCamposVacios = true;
        }

        return isCamposVacios;

    }
    /**
     * validaciones de entrada de login;
     */
    private boolean validaciones(){
        return !isCamposVacios();
    }

    /**
     * metodo del onClick del boton login
     * @param view boton login
     */
    public void login(View view){

        if(!validaciones()){
            return;
        }

        Log.i("APP", "Click en login");
        Intent intentLogin = new Intent(this, HomeActivity.class);
        intentLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //paso el email al HomeActivity
        intentLogin.putExtra(EMAIL_LOGIN_KEY, this.email);

        startActivity(intentLogin);
    }
}
