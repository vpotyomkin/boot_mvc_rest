package com.jm.boot_mvc.controllers;

import com.jm.boot_mvc.Service.RoleService;
import com.jm.boot_mvc.Service.UserService;
import com.jm.boot_mvc.models.Role;
import com.jm.boot_mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String showUser (@PathVariable("id") Long id, Model model){
        model.addAttribute("loggedUser", userService.getById(id));
        return "/user/currentUser";
    }

}