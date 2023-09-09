package org.Cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mapping.onetomanyandmanytoone.BankAccounts;
import org.mapping.onetomanyandmanytoone.Person;

import java.util.ArrayList;
import java.util.List;

public class CascadeDemo
{
    public static void main(String[] args)
    {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Person p1 = new Person();
        p1.setPersonId(5520);
        p1.setName("Neeta");

        BankAccounts b1 = new BankAccounts();
        b1.setAccountNo(738222);
        b1.setBankName("SBI");
        b1.setPerson(p1);

        BankAccounts b2 = new BankAccounts();
        b2.setAccountNo(289392);
        b2.setBankName("ICICI");
        b2.setPerson(p1);

        BankAccounts b3 = new BankAccounts();
        b3.setAccountNo(537220);
        b3.setBankName("HDFC");
        b3.setPerson(p1);


        List<BankAccounts> list= new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);

        p1.setBankAccountsList(list);


        Transaction transaction = session.beginTransaction();
        session.save(p1);
        // we don't have to do the below lines because we did cascading and implemented on Person class by using
        //cascade property....now no need to write save command for filling the data into all dependednt tables.

//        session.save(b1);
//        session.save(b2);
//        session.save(b3);


        transaction.commit();
        session.close();
        factory.close();


    }
}

