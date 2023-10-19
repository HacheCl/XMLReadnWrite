package org.example;

import java.io.File;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
public class XML_JAXB {
    public void guardarContactos(Agenda agenda, String ruta){
        JAXBContext jaxbContext = null;
        try {

            jaxbContext = JAXBContext.newInstance(Agenda.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // Escribe el contenido de la listga de contactos en el fichero
            jaxbMarshaller.marshal(agenda, new File(ruta));

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    public Agenda cargarContactos(String ruta) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Agenda.class);
            // Crea un objeto de tipo Unmarshaller para convertir datos XML en objetos Java
            return (Agenda)jaxbContext.createUnmarshaller().unmarshal(new File(ruta));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }


}

