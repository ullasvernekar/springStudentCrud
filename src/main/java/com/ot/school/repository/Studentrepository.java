package com.ot.school.repository;

import com.ot.school.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentrepository extends JpaRepository<Student, Long> {

    public Student findByRollNumber(String rollNumber);
}