package org.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.student.module.Student;
import org.student.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteStudentById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}
