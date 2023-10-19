package org.example;

import java.io.*;
import java.util.List;

public class ReadWriteObj {
    public void guardarObjetos(List<Contacto> contactos, String ruta) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(contactos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Contacto> leerObjetosDesdeArchivo(String ruta) {
        List<Contacto> contactos = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ruta))) {
            contactos = (List<Contacto>) in.readObject();
            System.out.println("Objetos leídos desde el archivo binario correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al leer objetos desde el archivo binario", e);
        }
        return contactos;
    }
}
