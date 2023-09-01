package org.ObjectState;

import org.example.Certificate;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo
{
    public static void main(String[] args)
    {
        //Practical of Hibernate Object States.
        //Transient State
        //Persistent State
        //Detached State
        //Removed State

        System.out.println("example started");
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        //Creating Student Object

        Student s= new Student();
        s.setId(90943);
        s.setCity("Bokaro Steel city");
        s.setName("Nitish Ojha");
        s.setCerti(new Certificate("C Fundamental","1 month"));
        // till here the student object is in Transient State.

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(s);
        // Now the student object is in Persistent State
        s.setName( "Sanjay Ojha ");
        transaction.commit();
        session.close();
        // Now thw student object is in Detached state
        s.setName("Peter Anderson");
        System.out.println(s);

        factory.close();

    }
}
