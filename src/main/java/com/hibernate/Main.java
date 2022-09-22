package com.hibernate;


import com.hibernate.entity.User;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Log4j2
public class Main {
    public static void main(String[] args) {

        log.info("Hibernate tutorial");
        Session session = HibernateUtil.getSessionFactory().openSession();

//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<User> criteriaDelete = cb.createCriteriaDelete(User.class);
        Root<User> root = criteriaDelete.from(User.class);
        criteriaDelete.where(cb.equal(root.get("id"), 10514));

        Transaction transaction = session.beginTransaction();
        session.createQuery(criteriaDelete).executeUpdate();
        transaction.commit();


       // criteriaQuery.select(root);

//        Predicate p1 = criteriaBuilder.gt(root.get("id"), 10001);
//        Predicate p2 = criteriaBuilder.lt(root.get("id"), 20001);
//
//        criteriaQuery.select(root).where(criteriaBuilder.and(p1, p2));
//
//        Query query = session.createQuery(criteriaQuery);
//        List<User> users = query.getResultList();

        session.close();
        HibernateUtil.close();

    }
}
