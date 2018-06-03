package com.maciej;

import com.maciej.entity.User;
import org.hibernate.Session;

public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtilities.getSessionFactory().openSession();

        // save User
        session.beginTransaction();
        User user = new User();
        user.setName("Joe");
        user.setGoal(250);
        session.save(user);
        session.getTransaction().commit();

        // get User
        session.beginTransaction();
        User loadedUser = (User) session.get(User.class, 1L);
        System.out.println(loadedUser.getName());
        System.out.println(loadedUser.getGoal());
        // Hibernate will do automatic update of User after changing using proxy
        loadedUser.setTotal(loadedUser.getTotal() + 50);
        session.getTransaction().commit();

        session.close();
        HibernateUtilities.getSessionFactory().close();
    }
}
