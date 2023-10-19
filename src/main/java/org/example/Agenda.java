package org.example;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class Agenda {
    private List<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList<>();
    }

    public void addContacto(Contacto contacto) {

        contactos.add(contacto);
    }
    private void removeContacto(Contacto contacto) {

        if(contactos.contains(contacto)){
            contactos.remove(contacto);
        }
    }
    public List<Contacto> getContactos() {
        return contactos;
    }
    public void listarLista(){
        for (Contacto contacto : contactos) {
            System.out.println(contacto.toString());
        }
    }
}
