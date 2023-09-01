package org.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainMapping
{
    public static void main(String[] args)
    {
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        // creating question
         Question q1= new Question();
         q1.setQuestionId(3932);
         q1.setQuestion("What is java?");

         // creating answer
         Answer a1= new Answer();
         a1.setAnswerId(292);
         a1.setAnswer("java is a high level programming language");
         a1.setQuestion(q1);

         q1.setAnswer(a1);



        Question q2= new Question();
        q2.setQuestionId(9823);
        q2.setQuestion("What is collection framewrok?");

        // creating answer
        Answer a2= new Answer();
        a2.setAnswerId(398);
        a2.setAnswer("API to work with multiple objects in java.");
        a2.setQuestion(q2);

        q2.setAnswer(a2);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        //saving
        session.save(q1);
        session.save(q2);
        session.save(a1);
        session.save(a2);

        transaction.commit();

        //fetchin

        Question ques = (Question) session.get(Question.class, 9823);
        System.out.println("Question_Id is: "+ques.getQuestionId()+" Question is: "+ques.getQuestion());
        System.out.println(" Answer details are: "+ques.getAnswer().getAnswer());

        session.close();
        factory.close();

    }
}
