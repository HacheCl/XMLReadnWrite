package org.example;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        XML_JAXB jaxb = new XML_JAXB();
        XML_DOM dom = new XML_DOM();
        XML_SAX sax = new XML_SAX();
        RWStrings rwStrings = new RWStrings();
        ReadWriteObj readWriteObj = new ReadWriteObj();
        Agenda agenda = new Agenda();
        for (int i = 0; i < 100; i++) {
            Contacto contacto = new Contacto(faker.leagueOfLegends().champion(), faker.number().numberBetween(100000000, 999999999));
            agenda.addContacto(contacto);
        }
        /*
          JAXB
          jaxb.guardarContactos(agenda, "contactos.xml");
          jaxb.cargarContactos("contactos.xml");
        */
        /*
          SAX
          sax.leerContactos("contactos.xml");
        */
        /*
          DOM
          dom.guardarContactos(agenda.getContactos(), "contactos.xml");
          dom.cargarContactos("contactos.xml");
        */
        /*
          //readWriteObj
          readWriteObj.guardarObjetos(agenda.getContactos(), "contactos.dat");
          readWriteObj.leerObjetosDesdeArchivo("contactos.dat");
        */
        /*
          //rwStrings
          rwStrings.guardarContactos(agenda.getContactos(), "contactos.dat");
          rwStrings.cargarContactos("contactos.dat");
        */
        agenda.listarLista();
    }
}
