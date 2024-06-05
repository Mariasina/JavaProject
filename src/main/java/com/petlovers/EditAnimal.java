package com.petlovers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.petlovers.model.AnimalData;
import com.petlovers.model.UserData;

public class EditAnimal {
    public static void editAnimal(String name, int age, String gender, String description, String type, String breed, long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery(
            "from AnimalData u where u.id = :id"
        );
         query.setParameter("id", id);
        // Chama a query
        List<AnimalData> pet = query.list();

        pet.get(0).setAge(age);
        pet.get(0).setBreed(breed); 
        pet.get(0).setDescription(description);
        pet.get(0).setGender(gender);
        pet.get(0).setName(name);
        pet.get(0).setType(type);

        session.update(pet.get(0));

        transaction.commit();
    }
}
