package com.solvd;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class XMLParser {

    public void parseXML(String xmlPath) {
        try {
            InputStream xmlStream = XMLParser.class.getResourceAsStream(xmlPath);

            if (xmlStream == null) {
                System.out.println("XML file not found: " + xmlPath);
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlStream);
            document.getDocumentElement().normalize();

            System.out.println("Root element: " + document.getDocumentElement().getNodeName());


        } catch (Exception e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }
}
