package com.osornet.estudioandroidudemy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvLista;
    private List<String> androidVersionList;

    private String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mapViews();
        setEmail();
        showList();

    }

    /**
     * mapeo de views de la activity
     */
    private  void mapViews(){
        lvLista = findViewById(R.id.lvLista);
    }

    /**
     * metodo que setea el email cargandolo de los sharedpreferences
     */
    private void setEmail(){

        Bundle extras = getIntent().getExtras();
        this.email = extras.getString(MainActivity.EMAIL_LOGIN_KEY);
    }

    /**
     * muestra la lista de elementos
     */
    private void showList(){
        this.androidVersionList = new ArrayList<>();

        //cambialos el titulo del toolbar con el email del usuario
        if(this.email != null && !this.email.isEmpty()){
            setTitle(this.email);
        }

        //carga de la lista de elementos
        androidVersionList.add("pie");
        androidVersionList.add("Oreo");
        androidVersionList.add("Nougat");
        androidVersionList.add("Marshmallow");
        androidVersionList.add("Lollipop");
        androidVersionList.add("Kitkat");
        androidVersionList.add("...");

        //adaptador
        ArrayAdapter<String> adaptadorVersionesAndroid = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                androidVersionList
        );
        //vinculacion del adaptador a su respectiva view
        this.lvLista.setAdapter(adaptadorVersionesAndroid);

        //eventos click de la lista
        this.lvLista.setOnItemClickListener(this);
}


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String androidVersion = this.androidVersionList.get(position);
        Log.i("APP", "Version click: ".concat(androidVersion));
    }
}
