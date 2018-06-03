package com.maciej;

import com.maciej.entity.User;
import org.hibernate.Session;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Session session = HibernateUtilities.getSessionFactory().openSession();

        session.beginTransaction();
        User user = new User();
        user.setName("Joe");
        user.setGoal(250);
        session.save(user);
        session.getTransaction().commit();

        session.close();
        HibernateUtilities.getSessionFactory().close();

    }
}
