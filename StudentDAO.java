package com.university.dao;

import com.university.model.Student;

public interface StudentDAO {
    Student validateStudent(String email, String password);
}