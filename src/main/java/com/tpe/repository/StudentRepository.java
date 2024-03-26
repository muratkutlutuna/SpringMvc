package com.tpe.repository;

import com.tpe.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void save(Student student);
    List<Student> getAll();
    Optional<Student> findById(Long id); //if there is no student with the id, it will throw exception
    // to handle this exception, we are using Optional class to get empty student obj

    void delete(Long id);
}
