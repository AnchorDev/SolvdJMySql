package com.solvd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.solvd.dao.ICustomerDao;
import com.solvd.dao.IPhoneDao;
import com.solvd.dao.CustomerDao;
import com.solvd.dao.PhoneDao;
import com.solvd.model.Customer;
import com.solvd.model.Customers;
import com.solvd.model.Phone;
import com.solvd.model.Order;
import com.solvd.model.Staff;
import com.solvd.model.Store;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws JAXBException, IOException {
        //-------DAO-------
        ICustomerDao customerDao = new CustomerDao();
        IPhoneDao phoneDao = new PhoneDao();

        Customer newCustomer = new Customer();
        newCustomer.setFullName("Alice Johnson");
        newCustomer.setEmail("alice.johnson@email.com");
        newCustomer.setPhone("555123456");
        customerDao.insert(newCustomer);

        Customer retrievedCustomer = customerDao.getEntityById(1);
        System.out.println("Customer Retrieved: " + retrievedCustomer);

        retrievedCustomer.setFullName("Updated Alice");
        customerDao.update(1, retrievedCustomer);
        System.out.println("Customer Updated: " + customerDao.getEntityById(1));

        customerDao.delete(1);
        System.out.println("Customer Deleted.");

        Phone newPhone = new Phone();
        newPhone.setName("iPhone 15 Pro");
        newPhone.setPrice(1299.99);
        newPhone.setBrandId(1);
        newPhone.setCategoryId(1);
        newPhone.setSupplierId(1);
        phoneDao.insert(newPhone);

        Phone retrievedPhone = phoneDao.getEntityById(1);
        System.out.println("Phone Retrieved: " + retrievedPhone);

        retrievedPhone.setName("Updated iPhone 15 Pro");
        phoneDao.update(1, retrievedPhone);
        System.out.println("Phone Updated: " + phoneDao.getEntityById(1));

        phoneDao.delete(1);
        System.out.println("Phone Deleted.");

        ExecutorService executorService = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 7; i++) {
            executorService.execute(() -> {
                System.out.println("Thread is executing a DAO operation.");
                phoneDao.getEntities();
            });
        }

        executorService.shutdown();

        //-------XML-------
        String xmlPath = "/phones.xml";
        String xsdPath = "/phones.xsd";

        XMLValidator.validateXMLSchema(xmlPath, xsdPath);
        XMLParser xmlParser = new XMLParser();
        xmlParser.parseXML(xmlPath);

        //-------DateXML-------
        System.out.println("-------DateXML-------");

        Customers customersFromXML = unmarshalCustomers();
        System.out.println("Unmarshalled Customers: " + customersFromXML);

        //-------DateJSON-------
        System.out.println("-------DateJSON-------");

        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(df);

        Customer customerJSON = new Customer(2, "John Smith", "john.smith@example.com", "555987654", new Date());
        Phone phoneJSON = new Phone(2, "Samsung Galaxy", 899.99, 1, 2, 1);
        Order orderJSON = new Order(1002, customerJSON.getCustomerId(), 1, new Date(), 1500.50, "Delivered");
        Staff staffJSON = new Staff(2, "Michael Brown", "Sales Manager", 101, new Date(), 50000.00);
        Store storeJSON = new Store(101, "TechHub", "123 Elm St");

        objectMapper.writeValue(new File("customer.json"), customerJSON);
        objectMapper.writeValue(new File("phone.json"), phoneJSON);
        objectMapper.writeValue(new File("order.json"), orderJSON);
        objectMapper.writeValue(new File("staff.json"), staffJSON);
        objectMapper.writeValue(new File("store.json"), storeJSON);

        Customer deserializedCustomer = objectMapper.readValue(new File("customer.json"), Customer.class);
        Phone deserializedPhone = objectMapper.readValue(new File("phone.json"), Phone.class);
        Order deserializedOrder = objectMapper.readValue(new File("order.json"), Order.class);
        Staff deserializedStaff = objectMapper.readValue(new File("staff.json"), Staff.class);
        Store deserializedStore = objectMapper.readValue(new File("store.json"), Store.class);

        System.out.println("Customer from JSON: " + deserializedCustomer);
        System.out.println("Phone from JSON: " + deserializedPhone);
        System.out.println("Order from JSON: " + deserializedOrder);
        System.out.println("Staff from JSON: " + deserializedStaff);
        System.out.println("Store from JSON: " + deserializedStore);
    }

    public static Customers unmarshalCustomers() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Customers.class);

        try (InputStream inputStream = Main.class.getResourceAsStream("/customers.xml")) {
            if (inputStream == null) {
                throw new IOException("File not found: customers.xml");
            }
            return (Customers) context.createUnmarshaller().unmarshal(inputStream);
        }
    }
}
