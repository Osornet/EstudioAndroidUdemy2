package com.osornet.estudioandroidudemy.jetpack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.osornet.estudioandroidudemy.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //quito el accionbar

        getSupportActionBar().hide();
    }
}
