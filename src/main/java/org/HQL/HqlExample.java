package org.HQL;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.mapping.onetomanyandmanytoone.BankAccounts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HqlExample
{
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        // syntax of hql
//        String query= "from Student where city= :x or name= :y";
//        Query query1 = session.createQuery(query);
//        query1.setParameter("x","Sasaram");
//        query1.setParameter("y","Sanjay Ojha");
//
//          //single(unique)
//        //multiple
//
//        List<Student> list = query1.list();
//        for (Student stu:list)
//        {
//            System.out.println(stu.getName());
//            System.out.println(stu.getCity()    );
//            System.out.println(stu.getCerti().getCourse());
//
//        }


       // System.out.println("-----------delete query--------------------------------------------------");

       Transaction transaction = session.beginTransaction();
//        Query query2 = session.createQuery("delete from Student  where city=:c");
//        query2.setParameter("c","Sasaram");
//        int i = query2.executeUpdate();
//        System.out.println("Deleted");
//        System.out.println(i);


        //System.out.println("----------------update query--------------------------------------------");
//        Query query3 = session.createQuery("update Student set city=:m where id=:n");
//        query3.setParameter("m", "Tatanagar");
//        query3.setParameter("n",90943);
//        int j = query3.executeUpdate();
//        System.out.println("updated");
//        System.out.println(j);


//        System.out.println("------------------delete query----------------------------");
//        Query query4 = session.createQuery("delete from Student where city =:c");
//        query4.setParameter("c","Patna");
//        int k= query4.executeUpdate();
//        System.out.println("deleted");
//        System.out.println(k);


//        System.out.println("update query");
//        Query query5 = session.createQuery("update Student set course=:m , duration=:p where id=:n");
//        query5.setParameter("m","React JS");
//        query5.setParameter("p","4 months");
//        query5.setParameter("n",9323);
//        int t = query5.executeUpdate();
//        System.out.println(" query updated");
//        System.out.println(t);

        // how to execute join query
        Query query6 =
                session.createQuery("select p.personId,p.name,ba from Person p  inner join p.bankAccountsList ba");
        List<Object[]> resultList = query6.getResultList();
        for(Object[] arr:resultList)
        {
            System.out.println(Arrays.toString(arr));
        }




        transaction.commit();

        session.close();

        factory.close();
    }
}

