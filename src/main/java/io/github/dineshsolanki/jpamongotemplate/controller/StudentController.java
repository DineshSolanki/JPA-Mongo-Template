package io.github.dineshsolanki.jpamongotemplate.controller;

import io.github.dineshsolanki.jpamongotemplate.db.entity.Student;
import io.github.dineshsolanki.jpamongotemplate.db.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("student/{name}")
    public Student getStudentById(@PathVariable String name) {
        return studentRepository.findStudentByNameIgnoreCase(name);
    }
}
