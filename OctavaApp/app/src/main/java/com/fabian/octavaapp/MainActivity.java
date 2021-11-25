package com.fabian.octavaapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText E1,E2,E3,E4;
    Button B1,B2,B3,B4;
    TextView T1;
    GestrDB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        T1=(TextView) findViewById(R.id.t1);
        E1=(EditText) findViewById(R.id.e1);
        E2=(EditText) findViewById(R.id.e2);
        E3=(EditText) findViewById(R.id.e3);
        E4=(EditText) findViewById(R.id.e4);
        B1=(Button) findViewById(R.id.b1);
        B2=(Button) findViewById(R.id.b2);
        B3=(Button) findViewById(R.id.b3);
        B4=(Button) findViewById(R.id.b4);
        DB=new GestrDB(this);
    }

    public void guardar(View view) {
      DB.insertData(E1.getText().toString(),E2.getText().toString(),E3.getText().toString());
    }

    public void consultar(View view) {
        Cursor res=DB.getData(E4.getText().toString());
        String informacio=null;
        if(res.moveToFirst())
        {
            informacio="ID="+res.getString(0)+"\n nombre="+res.getString(1)+"\n apellido"+res.getString(2);
        }
        T1.setText(informacio);
    }

    public void editar(View view) {
        DB.upDateData(E4.getText().toString(),E1.getText().toString(),E2.getText().toString(),E3.getText().toString());
    }

    public void borrar(View view) {
        DB.deleteData(E4.getText().toString());
    }
}