package com.jm.boot_mvc.controllers;

import com.jm.boot_mvc.Service.RoleService;
import com.jm.boot_mvc.Service.UserService;
import com.jm.boot_mvc.models.Role;
import com.jm.boot_mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping(path = "/users")
    public String getUsers() {
        return "/admin/users";}


    @GetMapping("/user")
    public String showUser (){
        return "/admin/currentUser";
    }


    @PostMapping(path = "/users")
    public String add(){
        return "redirect:/admin/users";
    }

    @DeleteMapping(path = "/users")
    public String deleteUser() {
        return "redirect:/admin/users";}

    @PutMapping(path = "/users")
    public String editUser() {
        return "redirect:/admin/users";}
}
