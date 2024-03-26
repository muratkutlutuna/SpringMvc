package com.tpe.service;

import com.tpe.domain.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);
    List<Student> getAllStudents();
    void deleteStudent(Long id);

    Student findStudentById(Long id);

}
