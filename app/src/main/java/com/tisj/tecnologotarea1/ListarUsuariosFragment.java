package com.tisj.tecnologotarea1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListarUsuariosFragment extends Fragment {

    public ListarUsuariosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listar_usuarios, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UsuarioDBHelper DBHelper = new UsuarioDBHelper(getContext());
        SQLiteDatabase db = DBHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                UsuarioContract.UsuarioEntry._ID,
                UsuarioContract.UsuarioEntry.COLUMN_NAME_ID,
                UsuarioContract.UsuarioEntry.COLUMN_NAME_NOMBRE
        };

        // Filter results WHERE "title" = 'My Title'
        //String selection = FeedEntry.COLUMN_NAME_TITLE + " = ?";
        //String[] selectionArgs = { "My Title" };

// How you want the results sorted in the resulting Cursor
        //String sortOrder =
        //        UsuarioContract.UsuarioEntry.COLUMN_NAME_ID + " DESC";

        Cursor c = db.query(
                UsuarioContract.UsuarioEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        // Find ListView to populate
        ListView lvItems = (ListView) getView().findViewById(R.id.listaUsuarios);
        // Setup cursor adapter using cursor from last step
        UsuarioCursorAdapter Adapter = new UsuarioCursorAdapter(getContext(), c);
        // Attach cursor adapter to the ListView
        lvItems.setAdapter(Adapter);
        }
}
