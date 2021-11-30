package com.csto.prueba3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioButton nulo,gb,jk;
    Button btn_v, btn_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nulo = (RadioButton) findViewById(R.id.rb_nulo);
        gb = (RadioButton) findViewById(R.id.rb_gb);
        jk = (RadioButton) findViewById(R.id.rb_jk);
        btn_v = (Button) findViewById(R.id.btn_votar);
        btn_resultado = (Button) findViewById(R.id.btn_res);


        btn_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nulo.isChecked()){
                    SQLiteDatabase db;
                    Dbhelper conn = new Dbhelper(getApplicationContext());
                    db=conn.getWritableDatabase();
                    ContentValues CV = new ContentValues();
                    CV.put("voto_nulo",+1);
                    db.insert("voto",null,CV);
                    Toast.makeText(getApplicationContext(),"Voto ingresado",Toast.LENGTH_LONG).show();
                }
                else if (gb.isChecked()){
                    SQLiteDatabase db;
                    Dbhelper conn = new Dbhelper(getApplicationContext());
                    db=conn.getWritableDatabase();
                    ContentValues CV = new ContentValues();
                    CV.put("voto_boric",+1);
                    db.insert("voto",null,CV);
                    Toast.makeText(getApplicationContext(),"Voto ingresado",Toast.LENGTH_LONG).show();

                }
                else if (jk.isChecked()){
                    SQLiteDatabase db;
                    Dbhelper conn = new Dbhelper(getApplicationContext());
                    db=conn.getWritableDatabase();
                    ContentValues CV = new ContentValues();
                    CV.put("voto_kast",+1);
                    db.insert("voto",null,CV);
                    Toast.makeText(getApplicationContext(),"Voto ingresado",Toast.LENGTH_LONG).show();

                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("¿Esta seguro de botar en blanco?")
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    SQLiteDatabase db;
                                    Dbhelper conn = new Dbhelper(getApplicationContext());
                                    db=conn.getWritableDatabase();
                                    ContentValues CV = new ContentValues();
                                    CV.put("voto_blanco",+1);
                                    db.insert("voto",null,CV);
                                    Toast.makeText(getApplicationContext(),"Voto ingresado",Toast.LENGTH_LONG).show();
                                    Intent I = new Intent(getApplicationContext(),Resultados.class);
                                    startActivity(I);
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User cancelled the dialog
                                }
                            });
                    // Create the AlertDialog object and return it
                    builder.create();
                    builder.show();

                }
                Intent N = new Intent(getApplicationContext(),Resultados.class);

            }
        });
        btn_resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rbN = "Nulo";
                String rbGB = "GabrielBoric";
                String rbK = "Jose Antonio Kast";
                String rbBlanco = "Blanco";
                Intent R = new Intent(getApplicationContext(),Resultados.class);
                R.putExtra("votoN",rbN);
                R.putExtra("votoB",rbGB);
                R.putExtra("votoK",rbK);
                R.putExtra("votoBlanco",rbBlanco);
                startActivity(R);
            }
        });

    }
}