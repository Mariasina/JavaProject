package com.petlovers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.petlovers.model.AnimalData;

public class EditAnimal {
    public static void editAnimal(String name, int age, String gender, String description, String type, String breed) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            String sql = "UPDATE AnimalData SET name = :name, age = :age, gender = :gender, description = :description, type = :type, breed = :breed WHERE id = :id";
            session.createSQLQuery(sql)
                .setParameter("name", name)
                .setParameter("age", age)
                .setParameter("gender", gender)
                .setParameter("description", description)
                .setParameter("type", type)
                .setParameter("breed", breed)
                .executeUpdate();
            
            transaction.commit();
            System.out.println("sucess");
        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erro ao atualizar dados: " + ex.getMessage());
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
