package com.petlovers;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.petlovers.model.AnimalData;
import com.petlovers.model.UserData;

public class AddAnimal {
    public static AddAnimal tryAddAnimal(int age, String breed, String description, String gender, String name, String type, UserData owner) {
        AddAnimal addAnimal = new AddAnimal();

        Session session = HibernateUtil
        .getSessionFactory()
        .getCurrentSession();
        Transaction transaction = session.beginTransaction();

        AnimalData data = new AnimalData();
        data.setAge(age);
        data.setBreed(breed); 
        data.setDescription(description);
        data.setGender(gender);
        data.setName(name);
        data.setType(type);
        data.setOwner(owner);

        session.save(data);

        transaction.commit();

        return addAnimal;
    }
}
