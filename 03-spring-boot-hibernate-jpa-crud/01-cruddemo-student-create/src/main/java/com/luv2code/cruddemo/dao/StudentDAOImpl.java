package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    // save theStudent in the database
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id); // id is the primary key
    }

    @Override
    public List<Student> findAll() {
        // create query
        // Noted: Student is not database table name, it is a JPA entity class name
        // All JPQL syntax is based on entity name and entity fields
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // return query result
        return theQuery.getResultList();
    }

}










