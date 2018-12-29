package com.travis.hibernate.demo;

import com.travis.hibernate.demo.entity.Instructor;
import com.travis.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 1);
            if (instructor != null) {
                session.delete(instructor);
            }
            session.getTransaction().commit();
        }
    }
}
