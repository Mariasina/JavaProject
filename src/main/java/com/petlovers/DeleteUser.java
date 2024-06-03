package com.petlovers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.petlovers.model.UserData;

public class DeleteUser {
    private UserData user = null;
    private Boolean userExists = false;

    public UserData getUser() {
        return this.user;
    }
    
    public Boolean userExists() {
        return this.userExists;
    }

    public static DeleteUser tryDeleteUser(String email, String pass){
        DeleteUser deleteUser = new DeleteUser();

        Session session = HibernateUtil
            .getSessionFactory()
            .getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery(
            "from UserData u where u.email = :user"
        );
        query.setParameter("user", email);
        List<UserData> users = query.list();

        if (users.size() == 0)
            return deleteUser;

        deleteUser.userExists = true;
        UserData loggedUser = users.get(0);

        if (!loggedUser.getPassword().equals(pass))
            return deleteUser;

        session.delete(loggedUser);
        
        deleteUser.user = loggedUser;

        transaction.commit();
        return deleteUser;
    }
}

