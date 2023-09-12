package org.HibernMappingUsingXML;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MainSubject
{
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Subject s1= new Subject(392,"Physics","Science","H C Verma");
        Subject s2= new Subject(383,"Hindi","Literature Hindi","Ashutosh kumar");


        session.save(s1);
        session.save(s2);




        transaction.commit();
        session.close();
        factory.close();

    }
}
