package com.solvd;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser {

    public void parseXML(String xmlPath) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(xmlPath));
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("phone");
            for (int i = 0; i < nList.getLength(); i++) {
                String brand = doc.getElementsByTagName("brand").item(i).getTextContent();
                String model = doc.getElementsByTagName("model").item(i).getTextContent();
                String price = doc.getElementsByTagName("price").item(i).getTextContent();
                String releaseDate = doc.getElementsByTagName("releaseDate").item(i).getTextContent();

                System.out.println("Phone:");
                System.out.println("Brand: " + brand);
                System.out.println("Model: " + model);
                System.out.println("Price: " + price);
                System.out.println("Release Date: " + releaseDate);
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
