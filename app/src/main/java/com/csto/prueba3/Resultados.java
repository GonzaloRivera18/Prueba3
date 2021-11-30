package com.csto.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Resultados extends AppCompatActivity {

    TextView b, n, g, k;
    Button btn_volver;
    Bundle v;

    ArrayList<String> Arr_votoN;
    ArrayList<String> Arr_votoB;
    ArrayList<String> Arr_votoK;
    ArrayList<String> Arr_votoBl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        btn_volver = (Button) findViewById(R.id.button);
        b = (TextView) findViewById(R.id.txt_blanco);
        n = (TextView) findViewById(R.id.txt_nulos);
        g = (TextView) findViewById(R.id.txt_boric);
        k = (TextView) findViewById(R.id.txt_kast);
        Arr_votoN = new ArrayList<String>();
        Arr_votoB = new ArrayList<String>();
        Arr_votoK = new ArrayList<String>();
        Arr_votoBl = new ArrayList<String>();

        v =getIntent().getExtras();
        String vN = v.getString("votoN");
        String vB = v.getString("votoB");
        String vK = v.getString("votoK");
        String vBl = v.getString("votoBlanco");

        if (vN.equals("Nulo"))
        {
            SQLiteDatabase db;
            Dbhelper conn = new Dbhelper(getApplicationContext());
            db=conn.getReadableDatabase();//abrir como lectura
            Cursor C = db.query("voto",null,null,null,null,null,null);
            if (C != null)
            {
                if(C.moveToFirst()) {
                    do {
                        String voton = C.getString(2);
                        Arr_votoN.add(voton);
                        n.setText(voton);
                    }
                    while (C.moveToNext()) ;
                }
            }
        }
        if (vB.equals("GabrielBoric"))
        {
            SQLiteDatabase db;
            Dbhelper conn = new Dbhelper(getApplicationContext());
            db=conn.getReadableDatabase();
            Cursor C = db.query("voto",null,null,null,null,null,null);
            if (C != null)
            {
                if(C.moveToFirst()) {
                    do {
                        String votog = C.getString(3);
                        Arr_votoB.add(votog);
                        g.setText(votog);
                    }
                    while (C.moveToNext()) ;
                }
            }
        }
        if (vK.equals("Jose Antonio Kast"))
        {
            SQLiteDatabase db;
            Dbhelper conn = new Dbhelper(getApplicationContext());
            db=conn.getReadableDatabase();
            Cursor C = db.query("voto",null,null,null,null,null,null);
            if (C != null)
            {
                if(C.moveToFirst()) {
                    do {
                        String votok = C.getString(4);
                        Arr_votoK.add(votok);
                        k.setText(votok);
                    }
                    while (C.moveToNext()) ;
                }
            }
        }
        else if (vBl.equals("Blanco"))
        {
            SQLiteDatabase db;
            Dbhelper conn = new Dbhelper(getApplicationContext());
            db=conn.getReadableDatabase();
            Cursor C = db.query("voto",null,null,null,null,null,null);
            if (C != null)
            {
                if(C.moveToFirst()) {
                    do {
                        String votoblanco = C.getString(1);
                        Arr_votoBl.add(votoblanco);
                        b.setText(votoblanco);
                    }
                    while (C.moveToNext()) ;
                }
            }
        }



        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);
            }
        });
    }
}