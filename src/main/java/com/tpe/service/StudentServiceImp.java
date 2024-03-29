package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    private StudentRepository repository;

    @Override
    public void saveStudent(Student student) {
        repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.getAll();
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = findStudentById(id);
        repository.delete(student.getId());
    }

    @Override
    public Student findStudentById(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student object not found with id: "+id));
    }
}
