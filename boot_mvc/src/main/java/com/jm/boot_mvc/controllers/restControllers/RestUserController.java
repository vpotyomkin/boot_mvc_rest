package com.jm.boot_mvc.controllers.restControllers;

import com.jm.boot_mvc.Service.UserService;
import com.jm.boot_mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/api/user")
public class RestUserController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<User> showUser (Principal principal){
        return new ResponseEntity<>(userService.getByUsername(principal.getName()), HttpStatus.OK);
    }

}