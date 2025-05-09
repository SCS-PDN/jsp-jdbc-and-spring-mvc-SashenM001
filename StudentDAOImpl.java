package com.university.dao;

import java.sql.*;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.university.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public Student validateStudent(String email, String password) {
        String sql = "SELECT * FROM students WHERE email=? AND password=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("student_id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
