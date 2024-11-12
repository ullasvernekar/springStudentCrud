package com.ot.school.controller;


import com.ot.school.dto.ResoponseStructure;
import com.ot.school.dto.Student;
import com.ot.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class Controller {

    @Autowired
    public StudentService studentService;

    @PostMapping(value = "/saveStudent")
    public ResponseEntity<ResoponseStructure<Student>> saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }


    @GetMapping(value = "/findByRollNumber/{rollNumber}")
    public ResponseEntity<ResoponseStructure<Student>> findByRollNumber(@PathVariable String rollNumber) {
        return studentService.findByRollNumber(rollNumber);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<ResoponseStructure<Student>> findById(@PathVariable long id) {
        return studentService.findById(id);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<ResoponseStructure<Student>> deleteStudent(@RequestParam long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<ResoponseStructure<List<Student>>> findAll() {
        return studentService.findAll();
    }

}