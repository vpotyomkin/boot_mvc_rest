package com.jm.boot_mvc.controllers.restControllers;

import com.jm.boot_mvc.Service.UserService;
import com.jm.boot_mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/api/admin")
public class RestAdminController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);}

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<User> getUsers(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getById(id),HttpStatus.OK);}

    @GetMapping("/user")
    public ResponseEntity<User> showUser (Principal principal){
        return new ResponseEntity<>(userService.getByUsername(principal.getName()), HttpStatus.OK);
    }


    @PostMapping(path = "/users")
    public ResponseEntity<User> add(@RequestBody User user){
        userService.add(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);}

    @PutMapping(path = "/users/{id}")
    public ResponseEntity<User> editUser(@RequestBody User user) {
        userService.edit(user);
        return new ResponseEntity<>(user, HttpStatus.OK);}
}
