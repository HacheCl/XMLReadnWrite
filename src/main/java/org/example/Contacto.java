package org.example;

import java.io.Serializable;

public class Contacto implements Serializable{
    private String nombre;
    private int telefono;
    public Contacto(String nombre, int telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public Contacto(){
    }
    public String getNombre(){
        return nombre;
    }
    public int getTelefono(){
        return telefono;
    }

    public void setNombre(String value) {
        this.nombre = value;
    }
    public void setTelefono(int value) {
        this.telefono = value;
    }
    public String toString() {
        return "Contacto:{" +
                "nombre:'" + nombre + '\'' +
                ", telefono:" + telefono +
                '}';
    }
}
