package org.HQL;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HqlPagination
{
    public static void main(String[] args)
    {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("from Student"); // this is HQL Query.

        // implementing pagination using Hibernate

        query.setFirstResult(4); // this defines from which row you are starting.
         query.setMaxResults(2); // this defines how many rows per page you needed.

        List<Student> resultList = query.getResultList();

        for (Student st: resultList)
        {
            System.out.println(st.getId()+"  "+st.getName()+"   "+st.getCity());
            
        }



        session.close();
        factory.close();

    }
}
