package com.tpe.repository;

import com.tpe.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImp implements StudentRepository{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(student); //if there is no object with same id,
        // new object will be saved to DB. If there is obj with the same id, it will update the obj

        tx.commit();
        session.close();
//        sessionFactory.close(); because bean handles life cycle
    }

    @Override
    public List<Student> getAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List<Student> studentList = session.createQuery("FROM Student", Student.class).getResultList();

        tx.commit();
        session.close();

        return studentList;
    }

    @Override
    public Optional<Student> findById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, id);
        tx.commit();
        session.close();

//        Student student = sessionFactory.getCurrentSession().getReference(Student.class, id);
        return Optional.ofNullable(student);// this student maybe null also
        //if it is null, it will return empty obj
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student student = session.getReference(Student.class, id);

        session.remove(student);
        tx.commit();
        session.close();

//        Student student = sessionFactory.getCurrentSession().getReference(Student.class, id);
//        sessionFactory.getCurrentSession().remove(student);
    }
}
