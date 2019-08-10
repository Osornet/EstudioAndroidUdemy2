package com.osornet.estudioandroidudemy.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.osornet.estudioandroidudemy.R;

public class PrincipalActivity extends AppCompatActivity {


    private boolean modoDia = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //carga de fragmento por defecto
        loadDefaultFragment();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Fragment f = null;

                f = modoDia?new ModoDiaFragment(): new ModoNocheFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, f)
                        .commit();

                modoDia = !modoDia;

            }
        });
    }

    private void loadDefaultFragment(){


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor, new ModoDiaFragment())
                .commit();
    }

}
