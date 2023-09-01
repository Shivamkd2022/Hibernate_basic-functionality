package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo
{
    public static void main(String[] args)
    {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // get() and load() functionality


        Student student = (Student) session.get(Student.class, 163);
        System.out.println(student);

        Student student1 = (Student) session.get(Student.class, 163);
        System.out.println(student1);





        Address address = (Address) session.load(Address.class, 2);
        Address address1 = (Address) session.load(Address.class, 1);
       System.out.println(address.getStreet()+"     "+address.getCity());
        System.out.println(address.getAddedDate());
        session.close();
        factory.close();

    }
}
