package org.mapping.onetomanyandmanytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MainOneToMany
{
    public static void main(String[] args)
    {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
//        Person p1= new Person();
//        p1.setPersonId(8065);
//        p1.setName("Prafull");
//
//
//        BankAccounts b1= new BankAccounts();
//        b1.setAccountNo(393994);
//        b1.setBankName("ICICI Bank");
//        b1.setPerson(p1);
//
//        BankAccounts b2= new BankAccounts();
//        b2.setAccountNo(1039033);
//        b2.setBankName("Canara Bank");
//        b2.setPerson(p1);
//
//        BankAccounts b3= new BankAccounts();
//        b3.setAccountNo(598383);
//        b3.setBankName("Union Bank");
//        b3.setPerson(p1);
//
//        List<BankAccounts> accountsList= new ArrayList<>();
//        accountsList.add(b1);
//        accountsList.add(b2);
//        accountsList.add(b3);
//
//        p1.setBankAccountsList(accountsList);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
//        session.save(p1);
//        session.save(b1);
//        session.save(b2);
//        session.save(b3);


        Person prsn = (Person) session.get(Person.class, 8065);
        System.out.println("Person Name is: "+prsn.getName());
        System.out.println(prsn.getBankAccountsList().size());
        for (BankAccounts ba:prsn.getBankAccountsList())
        {
            System.out.println(ba.getBankName());
            
        }

        transaction.commit();
        session.close();
        factory.close();





    }
}
