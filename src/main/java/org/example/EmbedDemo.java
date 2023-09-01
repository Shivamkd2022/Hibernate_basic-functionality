package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo
{
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Student st1= new Student();
        st1.setId(171);
        st1.setName("Amit kumar");
        st1.setCity("Sasaram");

        Certificate cer1= new Certificate();
        cer1.setCourse("Android");
        cer1.setDuration("2 months");

        st1.setCerti(cer1);





        Student st2= new Student();
        st2.setId(172);
        st2.setName("Kaushal Vishwas");
        st2.setCity("Patna");

        Certificate cer2= new Certificate();
        cer2.setCourse("Hibernate");
        cer2.setDuration("1.5 months");

        st2.setCerti(cer2);


        Transaction transaction = session.beginTransaction();
        session.save(st1);
        session.save(st2);

        transaction.commit();

        session.close();
        factory.close();
    }
}
