package com.maciej;

import com.maciej.entity.GoalAlert;
import com.maciej.entity.ProteinData;
import com.maciej.entity.User;
import com.maciej.entity.UserHistory;
import net.sf.ehcache.hibernate.EhCache;
import org.hibernate.*;

import java.util.Date;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        PopulateSampleData();

        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();

        //NAMED QUERY
        //Query query =  session.getNamedQuery("AllGoalAlerts");

//        // PAGING
//        Query query = session.createQuery("from GoalAlert").setFirstResult(2).setMaxResults(1);

        // DYNAMIC INSTANTIATION
//        Query query = session.createQuery("select new com.maciej.dto.UserTotal(user.name, user.proteinData.total) " +
//        		"from User user");

        // CRITERIA QUERY
//       Criteria criteria = session.createCriteria(User.class);
//        List<User> users = criteria.list();
//        for (User user : users) {
//            System.out.println(user.getName());
//        }

        // BATCH PROCESSING WITH HQL (BATCH UPDATE)
//        Query query = session.createQuery("update ProteinData pd set pd.total = 0");
//        query.executeUpdate();

        // MANUAL BATCHING
//        Criteria criteria = session.createCriteria(User.class);

        // We are using a cursor in the database; we get data when from database when we ask for as opposed to getting big data at once.
        // When we have a lot of Users, we may not have enough memory to load them at once;
//        ScrollableResults users = criteria.setCacheMode(CacheMode.IGNORE).scroll(); // not using 2nd-ary cache
//        int count = 0;
//        while (users.next()){
//            User user = (User) users.get(0);
//            user.setProteinData(new ProteinData());
//            session.save(user);
//            if (++count % 2 == 0){
//                session.flush();
//                session.clear();
//            }
//            System.out.println(user.getName());
//        }

        // NATIVE QUERY
//        Query query = session.createSQLQuery("SELECT * FROM Users").addEntity(User.class);
//        List<User> users = query.list();
//        for (User user : users) {
//            System.out.println(user.getName());
//        }

        session.getTransaction().commit();
        session.close();
        HibernateUtilities.getSessionFactory().close();
    }

    private static void PopulateSampleData() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();

        User joe = CreateUser("Joe", 500, 50, "Good job", "You made it!");
        session.save(joe);

        User bob = CreateUser("Bob", 300, 20, "Taco time!");
        session.save(bob);

        User amy = CreateUser("Amy", 250, 200, "Yes!!!");
        session.save(amy);
        session.getTransaction().commit();
        session.close();
    }

    private static User CreateUser(String name, int goal, int total, String... alerts) {
        User user = new User();
        user.setName(name);
        user.getProteinData().setGoal(goal);
        user.addHistory(new UserHistory(new Date(), "Set goal to " + goal));
        user.getProteinData().setTotal(total);
        user.addHistory(new UserHistory(new Date(), "Set total to " + total));
        for (String alert : alerts) {
            user.getGoalAlerts().add(new GoalAlert(alert));
        }

        return user;
    }
}
