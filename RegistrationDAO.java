package com.university.dao;

public interface RegistrationDAO {
    void registerStudent(int studentId, int courseId);
    boolean isAlreadyRegistered(int studentId, int courseId);
}
