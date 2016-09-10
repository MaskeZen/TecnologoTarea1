package com.tisj.tecnologotarea1;

import android.content.ContentValues;

import java.util.UUID;

/**
 * Created by Nicolás on 9/8/2016.
 */
public class Usuario {
    private String id;
    private String nombre;

    public Usuario(String name) {
        this.id = UUID.randomUUID().toString();
        this.nombre = name;
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
}
