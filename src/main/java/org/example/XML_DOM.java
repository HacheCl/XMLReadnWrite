package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class XML_DOM {
    public void guardarContactos(List<Contacto> contactos, String ruta){
        DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument(); // Crea un documento XML vacío
            Element root = doc.createElement("contactos"); // Crea el elemento raíz
            doc.appendChild(root);
            for (Contacto contacto: contactos) {
                Element eContacto = doc.createElement("contacto");
                Element eNombre = doc.createElement("nombre");
                eNombre.appendChild(doc.createTextNode(contacto.getNombre()));
                eContacto.appendChild(eNombre);
                Element eTelefono = doc.createElement("telefono");
                eTelefono.appendChild(doc.createTextNode(String.valueOf(contacto.getTelefono())));
                eContacto.appendChild(eTelefono);
                root.appendChild(eContacto);
            }
            // Crear un Transformer para escribir el documento en un archivo
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            // Convierte el documento XML
            StreamResult result = new StreamResult(new File(ruta));
            // Transforma el documento a un fichero
            transformer.transform(new DOMSource(doc), result);

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Contacto> cargarContactos(String ruta) {
        List<Contacto> contactosLista = new ArrayList<>();
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            doc = dbf.newDocumentBuilder().parse(new File(ruta));
        } catch (Exception e) {
            return null;
        }
        NodeList contactos = doc.getElementsByTagName("contacto");
        for (int i = 0; i < contactos.getLength(); i++) {
            Element contacto = (Element) contactos.item(i);
            String nombre = contacto.getElementsByTagName("nombre").item(0).getTextContent();
            int telefono = Integer.parseInt(contacto.getElementsByTagName("telefono").item(0).getTextContent());
            Contacto c = new Contacto(nombre, telefono);
            contactosLista.add(c);
        }
        return contactosLista;
    }
}
