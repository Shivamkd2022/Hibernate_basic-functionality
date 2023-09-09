package org.HQL;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class SqlExample
{
    public static void main(String[] args)
    {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Query query1 = session.createSQLQuery("select * from Student");// this is sql query, so for this
       // we have to use createSQLQuery() method.
        query1.setFirstResult(3);
        query1.setMaxResults(6);
        List<Object[]> resultList = query1.getResultList();
        for (Object[] ob:resultList)
        {
            System.out.println(Arrays.toString(ob));

        }
        session.close();;
        factory.close();


    }
}
