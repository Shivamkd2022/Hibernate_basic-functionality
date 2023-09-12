package org.CriteriaAPI;

import org.example.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CriteriaAPIExample
{
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Criteria criteria = session.createCriteria(Student.class);

        // adding restrictions

       // criteria.add(Restrictions.eq("certi.duration","1 month"));
       // criteria.add(Restrictions.gt("id",40000));
//        criteria.add(Restrictions.lt("id",53));
        criteria.add(Restrictions.like("city","P%"));


        List <Student> stulist = criteria.list();
        for (Student s:stulist)
        {
            System.out.println(s);

        }

    }
}
