package com.osornet.estudioandroidudemy.mensajes;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.osornet.estudioandroidudemy.R;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btToast, btSnackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal3);
        mapViews();
        setEventClick();
    }

    /**
     * metodo de mapeo de views
     */
    private void mapViews(){
        btToast = findViewById(R.id.btToast);
        btSnackBar = findViewById(R.id.btSnackBar);


    }

    /**
     * metodo en donde se setela el evento click de todos lo botones
     */
    private void setEventClick(){
        btToast.setOnClickListener(this);
        btSnackBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btToast:
                Toast.makeText(this, "Mostrando toast", Toast.LENGTH_LONG).show();
                break;
            case R.id.btSnackBar:
                Snackbar.make(v, "Mostrando SnackBar", Snackbar.LENGTH_LONG).show();
                break;
            default: Log.i("APP", "opcion no soportada");
        }



    }
}
