package com.solvd;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.InputStream;

public class XMLValidator {

    public static void validateXMLSchema(String xmlPath, String xsdPath) {
        try {
            InputStream xmlStream = XMLValidator.class.getResourceAsStream(xmlPath);
            InputStream xsdStream = XMLValidator.class.getResourceAsStream(xsdPath);

            if (xmlStream == null) {
                System.out.println("XML file not found: " + xmlPath);
                return;
            }
            if (xsdStream == null) {
                System.out.println("XSD file not found: " + xsdPath);
                return;
            }

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsdStream));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlStream));

            System.out.println("XML is valid.");
        } catch (Exception e) {
            System.out.println("XML is NOT valid because: " + e.getMessage());
        }
    }
}
