package com.tisj.tecnologotarea1;

import android.content.Intent;
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



    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


}
