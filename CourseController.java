package com.university.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.university.dao.CourseDAO;
import com.university.dao.RegistrationDAO;
import com.university.model.Course;
import com.university.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private RegistrationDAO registrationDAO;

    
    @GetMapping("/courses")
    public String showCourses(Model model, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        if (student == null) {
            return "redirect:/login";
        }

        List<Course> courses = courseDAO.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses";  
    }

    
    @PostMapping("/register/{courseId}")
    public String registerCourse(@PathVariable("courseId") int courseId, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        if (student == null) {
            return "redirect:/login";
        }

        boolean alreadyRegistered = registrationDAO.isAlreadyRegistered(student.getStudentId(), courseId);
        if (!alreadyRegistered) {
            registrationDAO.registerStudent(student.getStudentId(), courseId);
        }

        return "redirect:/success"; 
    }
}
