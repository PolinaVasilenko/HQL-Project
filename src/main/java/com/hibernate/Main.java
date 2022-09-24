package com.hibernate;


import com.hibernate.entity.User;
import jakarta.persistence.Query;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;


import java.util.List;

@Log4j2
public class Main {
    public static void main(String[] args) {

        log.info("Hibernate tutorial");

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("From User");
        List<User> users = query.getResultList();
        log.info(users);

        session.close();
        HibernateUtil.close();

    }
}
