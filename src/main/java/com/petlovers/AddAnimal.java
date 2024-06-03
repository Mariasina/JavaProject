package com.petlovers;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.petlovers.model.AnimalData;
import com.petlovers.model.UserData;

public class AddAnimal {
    public static AddAnimal tryAddAnimal(String name, int age, String gender, String description, String type, String breed, UserData owner) {
        AddAnimal addAnimal = new AddAnimal();

        Session session = HibernateUtil
        .getSessionFactory()
        .getCurrentSession();
        Transaction transaction = session.beginTransaction();

        AnimalData data = new AnimalData();
        data.setName(name);
        data.setAge(age);
        data.setGender(gender);
        data.setDescription(description);
        data.setType(type);
        data.setBreed(breed);
        data.setOwner(owner);

        session.save(data);

        transaction.commit();

        return addAnimal;
    }
}
