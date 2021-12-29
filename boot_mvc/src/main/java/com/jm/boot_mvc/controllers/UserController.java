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
@RequestMapping("")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;


    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "redirect:/users";
    }

    @GetMapping(value = "/")
    public String indexPage() {
        return "index";
    }

    @GetMapping(path = "/admin/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("userInfo",new User());
        model.addAttribute("allRoles", roleService.getAll());
        return "/admin/users";}

    @PostMapping(path = "/admin/users")
    public String add(@ModelAttribute("userInfo") User user, @ModelAttribute("rolesSelected") Set<Long> roles){
        Set<Role> roleSet = new HashSet<>();
        for (Long s : roles) {
            roleSet.add(roleService.getById(s));
        }
        user.setRoles(roleSet);
        userService.add(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping(path = "/admin/users/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/admin/users";}

    @GetMapping("/user")
    public String login (){
        return "/user";
    }

    @GetMapping("/{id}")
    public String showUser (@PathVariable("id") Long id, Model model){
        model.addAttribute("loggedUser", userService.getById(id));
        return "/user";
    }

    @GetMapping(path = "/admin/users/edit/{id}")
    public String getUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("allRoles", roleService.getAll());
        model.addAttribute("userToEdit", userService.getById(id));
        return "admin/edit";}

    @PatchMapping(path = "/admin/users/edit/{id}")
    public String editUser(@ModelAttribute("userToEdit") User userToEdit, @PathVariable("id") long id, @ModelAttribute("rolesSelected") Set<Long> roles, Model model) {
        model.addAttribute("userToEdit", userService.getById(id));
        Set<Role> roleSet = new HashSet<>();
        for (Long s : roles) {
            roleSet.add(roleService.getById(s));
        }
        userToEdit.setRoles(roleSet);
        userService.edit(userToEdit);
        return "redirect:/admin/users";}
}