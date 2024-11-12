package com.ot.school.services;


import com.ot.school.dao.StudentDao;
import com.ot.school.dto.ResoponseStructure;
import com.ot.school.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public ResponseEntity<ResoponseStructure<Student>> saveStudent(Student student) {
        ResoponseStructure<Student> resoponseStructure = new ResoponseStructure<>();
        Student student1 = studentDao.findByRollNUmber(student.getRollNumber());
        if (Objects.isNull(student1)) {
            resoponseStructure.setStatus(HttpStatus.CREATED.value());
            resoponseStructure.setMessage("Student saved successfully");
            resoponseStructure.setData(studentDao.saveStudent(student));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.CREATED);
        } else {
            resoponseStructure.setStatus(HttpStatus.CONFLICT.value());
            resoponseStructure.setMessage("Student Not saved ");
            resoponseStructure.setData(null);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<ResoponseStructure<Student>> findByRollNumber(String rollNumber) {
        ResoponseStructure<Student> responseStructure = new ResoponseStructure<>();
        Student student = studentDao.findByRollNUmber(rollNumber);
        if (Objects.isNull(student)) {
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("Not Found by RollNumber ");
            responseStructure.setData(studentDao.findByRollNUmber(null));
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        } else {
            responseStructure.setStatus(HttpStatus.OK.value());
            responseStructure.setMessage("Roll Number Found" + rollNumber);
            responseStructure.setData(student);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
    }

    public ResponseEntity<ResoponseStructure<Student>> findById(long id) {
        ResoponseStructure<Student> resoponseStructure = new ResoponseStructure<>();
        Student student = studentDao.findById(id);
        if (Objects.isNull(student)) {
            resoponseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            resoponseStructure.setMessage("ID Not Found ");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NOT_FOUND);
        } else {
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Found by ID" + id);
            resoponseStructure.setData(student);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }

    public ResponseEntity<ResoponseStructure<List<Student>>> findAll() {
        ResoponseStructure<List<Student>> resoponseStructure = new ResoponseStructure<>();
        List<Student> student = studentDao.findAll();
        if (Objects.isNull(student)) {
            resoponseStructure.setStatus(HttpStatus.NO_CONTENT.value());
            resoponseStructure.setMessage("NO Content is Found");
            resoponseStructure.setData(null);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NO_CONTENT);
        } else {
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Found All Student Data");
            resoponseStructure.setData(student);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }

    public ResponseEntity<ResoponseStructure<Student>> deleteStudent(long id) {
        ResoponseStructure<Student> resoponseStructure = new ResoponseStructure<>();
        Student student = studentDao.findById(id);
        if (Objects.isNull(student)) {
            resoponseStructure.setStatus(HttpStatus.NO_CONTENT.value());
            resoponseStructure.setMessage("NO Content is Found");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NO_CONTENT);
        } else {
            studentDao.deleteStudent(student);
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Deleted a Student");
            resoponseStructure.setData(student);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }
}

