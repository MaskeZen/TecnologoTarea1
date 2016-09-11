package com.tisj.tecnologotarea1;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Nicolás on 9/10/2016.
 */
public class UsuarioCursorAdapter extends CursorAdapter {
    public UsuarioCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.usuario_list_item, parent, false);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView tvid = (TextView) view.findViewById(R.id.userId);
        TextView tvnombre = (TextView) view.findViewById(R.id.userNombre);
        // Extract properties from cursor
        int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
        // Populate fields with extracted properties
        tvid.setText(String.valueOf(id));
        tvnombre.setText(nombre);
    }
}
