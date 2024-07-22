package org.student.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.student.module.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addStudent(Student student)
    {
        String sql = "INSERT INTO students (first_name, last_name, middle_name, date_of_birth, student_group) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getMiddleName(), student.getDateOfBirth(), student.getGroup());
    }

    public void deleteStudentById(Long id)
    {
        String sql = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Student> getAllStudents()
    {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    private static class StudentRowMapper implements RowMapper<Student>
    {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setFirstName(rs.getString("first_name"));
            student.setLastName(rs.getString("last_name"));
            student.setMiddleName(rs.getString("middle_name"));
            student.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
            student.setGroup(rs.getString("student_group"));
            return student;
        }
    }
}
