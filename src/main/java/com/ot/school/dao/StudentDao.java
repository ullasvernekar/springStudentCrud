package com.ot.school.dao;


import com.ot.school.dto.Student;
import com.ot.school.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDao {

    @Autowired
    private Studentrepository studentRepository;


    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findByRollNUmber(String rollNumber) {
        return studentRepository.findByRollNumber(rollNumber);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public Student findById(long id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.orElse(null);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}