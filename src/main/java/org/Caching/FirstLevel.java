package org.Caching;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevel
{
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        // first level cache is by default associated.

        Student s1 = session.get(Student.class, 241);
        System.out.println(s1);
        System.out.println("working something........");
        Student s2 = session.get(Student.class, 241);
        System.out.println(s2);


        session.close();
        factory.close();
    }
}
