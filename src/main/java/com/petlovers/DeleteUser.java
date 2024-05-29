package com.petlovers;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteUser {
    public static DeleteUser tryDeleteUser(){
        DeleteUser deleteUser = new DeleteUser();

        Session session = HibernateUtil
        .getSessionFactory()
        .getCurrentSession();
        Transaction transaction = session.beginTransaction();

        
    }
}
