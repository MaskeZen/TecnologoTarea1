package com.tisj.tecnologotarea1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Nicolás on 9/9/2016.
 */
public class UsuarioContract {

        private UsuarioContract() {}

        public static class UsuarioEntry implements BaseColumns {
            public static final String TABLE_NAME = "Usuario";
            public static final String COLUMN_NAME_ID = "id";
            public static final String COLUMN_NAME_NOMBRE = "nombre";
        }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_USUARIO =
            "CREATE TABLE " + UsuarioEntry.TABLE_NAME + " (" +
                    UsuarioEntry._ID + " INTEGER PRIMARY KEY," +
                    UsuarioEntry.COLUMN_NAME_ID + TEXT_TYPE + COMMA_SEP +
                    UsuarioEntry.COLUMN_NAME_NOMBRE + TEXT_TYPE + " )";

    public static final String SQL_DELETE_USUARIO =
            "DROP TABLE IF EXISTS " + UsuarioEntry.TABLE_NAME;
}
