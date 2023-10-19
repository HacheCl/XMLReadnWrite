package org.example;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.Attributes;
public class XML_SAX {
    public List<Contacto> leerContactos(String ruta) {
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            ContactoHandler handler = new ContactoHandler(); // Handler personalizado
            xmlReader.setContentHandler(handler);
            xmlReader.parse(ruta);

            // Una vez que la lectura del archivo esté completa, puedes acceder a los datos
            ArrayList<Contacto> contactos = handler.getContactos();
            return contactos;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class ContactoHandler extends DefaultHandler {
        private ArrayList<Contacto> contactos;
        private Contacto currentContacto;
        private String currentElement;

        public ArrayList<Contacto> getContactos() {
            return contactos;
        }

        public void startDocument() throws SAXException {
            contactos = new ArrayList<>();
        }


        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            if ("Contacto".equalsIgnoreCase(currentElement)) {
                currentContacto = new Contacto();
            }
        }


        public void characters(char[] ch, int start, int length) throws SAXException {
            String value = new String(ch, start, length).trim();
            if (currentContacto != null) {
                if ("nombre".equalsIgnoreCase(currentElement)) {
                    currentContacto.setNombre(value);
                } else if ("telefono".equals(currentElement)) {
                    currentContacto.setTelefono(Integer.parseInt(value));
                }
            }
        }


        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("Contacto".equalsIgnoreCase(qName)) {
                contactos.add(currentContacto);
                currentContacto = null;
            }
        }
    }

}
