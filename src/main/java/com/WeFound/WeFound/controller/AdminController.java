package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        List<User> userList = adminService.getAllUsers();
        model.addAttribute("userList", userList);
        return "admin";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    @PostMapping("/admin/updateGrade")
    public String updateUserGrade(@RequestParam("userId") Long userId, @RequestParam("grade") String grade) {
        adminService.updateUserGrade(userId, grade);
        return "redirect:/admin";
    }

    @PostMapping("/admin/updatePoint")
    public String updateUserPoint(@RequestParam("userId") Long userId, @RequestParam("point") Long point) {
        adminService.updateUserPoint(userId, point);
        return "redirect:/admin";
    }
}