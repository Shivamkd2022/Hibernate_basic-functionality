package org.Caching;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;

public class SecondCache
{
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session1 = factory.openSession();

        Student s1 = session1.get(Student.class, 835);
        System.out.println(s1);
        session1.close();


        System.out.println("-------------------------------------------- ");

        Session session2 = factory.openSession();

        Student s2 = session2.get(Student.class, 835);
        System.out.println(s2);

        session2.close();

        factory.close();


    }
}
