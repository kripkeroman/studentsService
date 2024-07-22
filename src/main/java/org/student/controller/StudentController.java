package org.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.student.module.Student;
import org.student.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{
    @Autowired
    private StudentService studentService;

    /**
     * Endpoint to add a new student.
     *
     * @param student the student to add
     */
    @PostMapping
    public void addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
    }

    /**
     * Endpoint to delete a student by unique ID.
     *
     * @param id the ID of the student to delete
     */
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id)
    {
        studentService.deleteStudentById(id);
    }

    /**
     * Endpoint to get a list of all students.
     *
     * @return the list of all students
     */
    @GetMapping
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }
}
