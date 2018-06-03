package com.maciej;

import org.hibernate.Session;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.close();

    }
}
