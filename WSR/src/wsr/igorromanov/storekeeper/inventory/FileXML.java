package wsr.igorromanov.storekeeper.inventory;

import wsr.igorromanov.storekeeper.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class FileXML {

     private static Document createXML() {
        Document document = null;
         try {
             //Создаем документ
             DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
             document = documentBuilder.newDocument();
             
         } catch (ParserConfigurationException ex) {
             Logger.getLogger(FileXML.class.getName()).log(Level.SEVERE, null, ex);
         }
         return document;
     
     }
     
    
    public static void fabricModel(ArrayList<FieldStorage> list, String URL){
         try {
              // Получаем документ для модели
             Document document = createXML();
             System.out.println(document);
             //Создаем структуру XML
             Element cataloge = document.createElement("Cataloge");
             document.appendChild(cataloge);
             for (int i = 0; i < list.size(); i++) {
                 
                 Element fabric = document.createElement("Fabric");
                 cataloge.appendChild(fabric);
                 
                 Element name = document.createElement("Name");
                 name.appendChild(document.createTextNode(list.get(i).getNameFabric()));
                 fabric.appendChild(name);
                 System.out.println(Arrays.asList(list.get(i).getNameFabric()));
                 
                 Element consist = document.createElement("Consist");
                 consist.appendChild(document.createTextNode(list.get(i).getConsist()));
                 fabric.appendChild(consist);
                 
                 Element colour = document.createElement("Colour");
                 colour.appendChild(document.createTextNode(list.get(i).getColour()));
                 fabric.appendChild(colour);
                 
                 Element width = document.createElement("Width");
                 width.appendChild(document.createTextNode(String.valueOf(list.get(i).getWidthFabric())));
                 fabric.appendChild(width);
                 
                 Element length = document.createElement("Length");
                 length.appendChild(document.createTextNode(String.valueOf(list.get(i).getLengthFabric())));
                 fabric.appendChild(length);
             }
             writeDocument(document, URL);
         } catch (TransformerFactoryConfigurationError ex) {
             Logger.getLogger(FileXML.class.getName()).log(Level.SEVERE, null, ex);
         } catch (FileNotFoundException ex) {
             Logger.getLogger(FileXML.class.getName()).log(Level.SEVERE, null, ex);
         } catch (TransformerException ex) {
             Logger.getLogger(FileXML.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public static void fittingsModel(ArrayList<FieldStorage> list, String URL){
         try {
             // Получаем документ для модели
             Document document = createXML();
             
             //Создаем структуру XML
             Element cataloge = document.createElement("Cataloge");
             document.appendChild(cataloge);
             for (int i = 0; i < list.size(); i++) {
                 
                 Element fittings = document.createElement("Fittings");
                 cataloge.appendChild(fittings);
                 
                 Element name = document.createElement("Name");
                 name.appendChild(document.createTextNode(list.get(i).getNameFittings()));
                 fittings.appendChild(name);
                 
                 
                 Element type = document.createElement("Type");
                 type.appendChild(document.createTextNode(list.get(i).getType()));
                 fittings.appendChild(type);
                 
                 Element heft = document.createElement("Heft");
                 heft.appendChild(document.createTextNode(String.valueOf(list.get(i).getHeft())));
                 fittings.appendChild(heft);
                 
                 Element amount = document.createElement("Amount");
                 amount.appendChild(document.createTextNode(String.valueOf(list.get(i).getAmount())));
                 fittings.appendChild(amount);
                 
             }
             writeDocument(document, URL);
         } catch (TransformerFactoryConfigurationError ex) {
             Logger.getLogger(FileXML.class.getName()).log(Level.SEVERE, null, ex);
         } catch (FileNotFoundException ex) {
             Logger.getLogger(FileXML.class.getName()).log(Level.SEVERE, null, ex);
         } catch (TransformerException ex) {
             Logger.getLogger(FileXML.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    
    }
    
    
    
     private static void writeDocument(Document document,String URL) throws TransformerFactoryConfigurationError, TransformerConfigurationException, FileNotFoundException, TransformerException {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream(URL);
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
     
}

