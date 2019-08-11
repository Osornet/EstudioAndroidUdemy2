package com.osornet.estudioandroidudemy.reciclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.osornet.estudioandroidudemy.R;

public class PrincipalActivity extends AppCompatActivity implements RestauranteFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal4);
    }

    @Override
    public void onListFragmentInteraction(Restaurante item) {
        Log.i("CLICK","el item seleccionado es: ".concat(item.toString()));
    }
}
