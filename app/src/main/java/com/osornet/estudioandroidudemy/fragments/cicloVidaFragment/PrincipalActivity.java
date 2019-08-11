package com.osornet.estudioandroidudemy.fragments.cicloVidaFragment;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.osornet.estudioandroidudemy.R;

public class PrincipalActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal2);

        Toast.makeText(this, "Mensaje desde activity", Toast.LENGTH_LONG);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
