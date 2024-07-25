package com.app.firstcrudwithspringboot.Student;

import com.app.firstcrudwithspringboot.Student.impl.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    StudentServiceImpl studentService;

    StudentController(StudentServiceImpl studentService){
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/student")
    public ResponseEntity createStudent(@RequestBody Student newStudent){
        studentService.createStudent(newStudent);
        return new ResponseEntity<>("Student created successfullu", HttpStatus.CREATED);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity updateStudent(@PathVariable Long id, @RequestBody Student updateStudent){
        studentService.updateStudent(id, updateStudent);
        return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
    }

}
