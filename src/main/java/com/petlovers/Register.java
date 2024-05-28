package com.petlovers;
import java.sql.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Register {
    public static Register tryRegister(String full_name, String username, Date birthdate, String cpf, String password, String email, String phone) {
        Register register = new Register();

        Session session = HibernateUtil
        .getSessionFactory()
        .getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery(
            "insert into UserData (u.bithdate, u.cpf, u.email, u.full_name, u.password, u.phone, u.username, u.user_adress_id) = :birthdate, :cpf, :email, :full_name, :password, :phone, :username, 1"
        );
        transaction.commit();

        return register;
    }
}
