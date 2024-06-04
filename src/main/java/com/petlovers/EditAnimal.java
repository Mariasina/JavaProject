package com.petlovers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.petlovers.model.AnimalData;

public class EditAnimal {
    public static void editAnimal(String name, int age, String gender, String description, String type, String breed, AnimalData pet) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        pet.setAge(age);
        pet.setBreed(breed); 
        pet.setDescription(description);
        pet.setGender(gender);
        pet.setName(name);
        pet.setType(type);

        session.update(pet);

        transaction.commit();
    }
}
