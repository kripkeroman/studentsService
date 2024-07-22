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

    /**
     * Add new student
     *
     * @param student
     */
    public void addStudent(Student student)
    {
        String sql = "INSERT INTO students (first_name, last_name, middle_name, date_of_birth, student_group) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getMiddleName(), student.getDateOfBirth(), student.getGroup());
    }

    /**
     * Delete student by ID
     *
     * @param id
     */
    public void deleteStudentById(Long id)
    {
        String sql = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * Get all students
     *
     * @return
     */
    public List<Student> getAllStudents()
    {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    /**
     * StudentRowMapper is a static inner class that implements the RowMapper interface
     * for mapping rows of a ResultSet to instances of the Student class.
     *
     */
    private static class StudentRowMapper implements RowMapper<Student>
    {
        /**
         * Maps a single row of a ResultSet to an instance of the Student class.
         *
         * @param rs the ResultSet to map (pre-initialized for the current row)
         * @param rowNum the number of the current row
         * @return the Student object for the current row
         * @throws SQLException if a SQLException is encountered getting column values
         */
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
