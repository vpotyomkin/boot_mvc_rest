package com.jm.boot_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
