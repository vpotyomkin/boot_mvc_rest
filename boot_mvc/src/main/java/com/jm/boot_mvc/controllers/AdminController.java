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
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(path = "")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("userInfo",new User());
        model.addAttribute("allRoles", roleService.getAll());
        return "/admin/users";}

    @PostMapping(path = "/users")
    public String add(@ModelAttribute("userInfo") User user, @RequestParam("rolesSelected") Long[] roles){
        Set<Role> roleSet = new HashSet<>();
        for (Long s : roles) {
            roleSet.add(roleService.getById(s));
        }
        user.setRoles(roleSet);
        userService.add(user);
        return "redirect:/admin";
    }

    @DeleteMapping(path = "/users/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/admin";}

    @GetMapping(path = "/users/edit/{id}")
    public String getUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("allRoles", roleService.getAll());
        model.addAttribute("userToEdit", userService.getById(id));
        return "admin/edit";}

    @PatchMapping(path = "/users/edit/{id}")
    public String editUser(@ModelAttribute("userToEdit") User userToEdit, @PathVariable("id") long id, @RequestParam("rolesSelected") Long[] roles, Model model) {
        model.addAttribute("userToEdit", userService.getById(id));
        Set<Role> roleSet = new HashSet<>();
        for (Long s : roles) {
            roleSet.add(roleService.getById(s));
        }
        userToEdit.setRoles(roleSet);
        userService.edit(userToEdit);
        return "redirect:/admin";}
}
