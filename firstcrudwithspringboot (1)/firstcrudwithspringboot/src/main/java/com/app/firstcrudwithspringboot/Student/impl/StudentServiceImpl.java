package com.app.firstcrudwithspringboot.Student.impl;

import com.app.firstcrudwithspringboot.Student.Student;
import com.app.firstcrudwithspringboot.Student.StudentRepository;
import com.app.firstcrudwithspringboot.Student.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepo;

    StudentServiceImpl(StudentRepository studentRepo){
        this.studentRepo = studentRepo;
    }
    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void createStudent(Student newStudent) {
        studentRepo.save(newStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public void updateStudent(Long id, Student studentToUpdate) {
        Optional<Student> student = studentRepo.findById(id);

        if(student.isPresent()){
            Student updateStudent = student.get();
            updateStudent.setName(studentToUpdate.getName());
            updateStudent.setAge(studentToUpdate.getAge());
            updateStudent.setStandard(studentToUpdate.getStandard());
            studentRepo.save(updateStudent);
        }
    }
}
