package com.tisj.tecnologotarea1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class InsertarUsuarioFragment extends Fragment {

    public InsertarUsuarioFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_insertar_usuario, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            Button bttInsertUsuario = (Button) getView().findViewById(R.id.bttInsertUsuario);
            bttInsertUsuario.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    TextView textview = (TextView) getView().findViewById(R.id.edit_message);
                    String nombre = textview.getText().toString();

                    Usuario usuario = new Usuario(nombre);

                    UsuarioDBHelper DBHelper = new UsuarioDBHelper(getContext());

                    // Gets the data repository in write mode
                    SQLiteDatabase db = DBHelper.getWritableDatabase();

                    // Create a new map of values, where column names are the keys
                    ContentValues values = new ContentValues();
                    values.put(UsuarioContract.UsuarioEntry.COLUMN_NAME_ID, usuario.getId());
                    values.put(UsuarioContract.UsuarioEntry.COLUMN_NAME_NOMBRE, nombre);

                    // Insert the new row, returning the primary key value of the new row
                    long newRowId = db.insert(UsuarioContract.UsuarioEntry.TABLE_NAME, null, values);

                    textview.setText("");
                    //Intent intent = new Intent(getActivity(),ListarUsuarios.class);
                    //startActivity(intent);
                }
            });
        }
        catch  (Exception ex)
        {
         String error = ex.getMessage();
        }
    }
}
