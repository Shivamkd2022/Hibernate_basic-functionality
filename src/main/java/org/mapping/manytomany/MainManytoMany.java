package org.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MainManytoMany
{
    public static void main(String[] args)
    {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Employee e1= new Employee();
        Employee e2= new Employee();

        e1.setEmpId(73387);
        e1.setName("Atul kumar Chaurasiya");

        e2.setEmpId(76473);
        e2.setName("Pramod Jaiswal");


        Project p1= new Project();
        Project p2= new Project();

        p1.setProjId(2011);
        p1.setProjName("Google Bard");

        p2.setProjId(2014);
        p2.setProjName("Anaplan");

        List<Employee> employeeList= new ArrayList<>();
        List<Project> projectList= new ArrayList<>();

        employeeList.add(e1);
        employeeList.add(e2);

        projectList.add(p1);
        projectList.add(p2);


        e1.setProjects(projectList);
        p2.setEmployees(employeeList);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);

        transaction.commit();
        session.close();
        factory.close();




    }
}
