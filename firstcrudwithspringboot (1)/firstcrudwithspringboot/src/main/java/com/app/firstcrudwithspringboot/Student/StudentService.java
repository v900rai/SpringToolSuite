package com.app.firstcrudwithspringboot.Student;

import java.util.List;

public interface StudentService {
    public List<Student>getStudents();

    public  void createStudent(Student newStudent);

    public void deleteStudent(Long id);

    public void updateStudent(Long id, Student studentToUpdate);
}
