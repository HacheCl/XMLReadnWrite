package org.example;

import java.io.*;
import java.util.List;

public class RWStrings {
    public void guardarContactos(List<Contacto> contactos, String ruta) {
        File file = new File(ruta);
        String linea;
        try {
            try {
                BufferedWriter br = new BufferedWriter(new FileWriter(file));
                for (Contacto contacto : contactos) {
                    linea = contacto.getNombre() + "," + contacto.getTelefono() + "\n";
                    br.write(linea);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Contacto> cargarContactos(String ruta) {
        List<Contacto> contactos = null;
        try {
            try {
                BufferedReader br = new BufferedReader(new FileReader(ruta));
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(",");
                    Contacto contacto = new Contacto(datos[0], Integer.parseInt(datos[1]));
                    contactos.add(contacto);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return contactos;
    }
}



