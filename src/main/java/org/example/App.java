package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        System.out.println("project started");
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
       //  creating student object
        Student st= new Student(164,"krunal","Gandhinagar");
        System.out.println(st);

       //  creating address object
        Address ad= new Address();
        ad.setStreet("M G Road");
        ad.setCity("Agra");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(9293.9494);

        // Reading images
        FileInputStream fis= new FileInputStream("src/main/resources/msd112.jpg");
        byte[] data= new byte[fis.available()];
        fis.read(data);

        ad.setImage(data);




        Session session= factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(st);
        session.save(ad);

        transaction.commit();
        session.close();

    }
}