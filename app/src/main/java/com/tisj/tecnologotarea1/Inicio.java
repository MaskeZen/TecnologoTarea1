package com.tisj.tecnologotarea1;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inicio extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.tisj.tecnologotarea1.EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Button bttInsertarUsuario = (Button) findViewById(R.id.inicio_insertarUsuario);
        bttInsertarUsuario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this,InsertarUsuario.class);
                startActivity(intent);
            }
        });

        Button bttListarUsuarios = (Button) findViewById(R.id.inicio_listarUsuario);
        bttListarUsuarios.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this,ListarUsuarios.class);
                startActivity(intent);
            }
        });
    }
}
