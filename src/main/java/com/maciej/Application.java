package com.maciej;

import com.maciej.entity.GoalAlert;
import com.maciej.entity.ProteinData;
import com.maciej.entity.User;
import com.maciej.entity.UserHistory;
import org.hibernate.Session;

import java.util.Date;

public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtilities.getSessionFactory().openSession();

        // save User
        session.beginTransaction();
        User user = new User();
        user.setName("Joe");
        user.addHistory(new UserHistory(new Date(), "Set name to Joe"));
        user.getProteinData().setGoal(250);
        user.addHistory(new UserHistory(new Date(), "Set the goal to 250"));
        user.setGoalAlert(new GoalAlert("Congratulations!"));
        session.save(user);
        session.getTransaction().commit();

        // get User
        session.beginTransaction();
        User loadedUser = (User) session.get(User.class, 1L);
        System.out.println(loadedUser.getName());
        System.out.println(loadedUser.getProteinData().getGoal());
        for (UserHistory history : loadedUser.getHistory()) {
            System.out.println(history.getEntryTime().toString() + " " + history.getEntry());
        }
        // Hibernate will do automatic update of User after changing using proxy
        loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 50);
        loadedUser.addHistory(new UserHistory(new Date(), "Added 50 protein"));

        user.setProteinData(new ProteinData());

        session.getTransaction().commit();

        session.close();
        HibernateUtilities.getSessionFactory().close();
    }
}
