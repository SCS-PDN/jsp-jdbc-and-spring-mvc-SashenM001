package com.university.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.university.dao.StudentDAO;
import com.university.model.Student;

@Controller
public class LoginController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";  
    }

    @PostMapping("/login")
    public String validateLogin(@RequestParam String email,
                                @RequestParam String password,
                                HttpSession session,
                                Model model) {
        Student student = studentDAO.validateStudent(email, password);
        if (student != null) {
            session.setAttribute("student", student);
            return "redirect:/courses";
        } else {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }
    }
}
