package com.jm.boot_mvc.config;

import com.jm.boot_mvc.Service.RoleService;
import com.jm.boot_mvc.Service.UserService;
import com.jm.boot_mvc.models.Role;
import com.jm.boot_mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitUsers {
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

    @PostConstruct
    public void Init() {
        Role adminRole = new Role("ADMIN");
        roleService.add(adminRole);

        Role userRole = new Role("USER");
        roleService.add(userRole);

        Set<Role> adminRoles = new HashSet<>(Collections.singleton(adminRole));
        User adminUser = new User("admin", "admin", "admin", "admin", adminRoles);
        userService.add(adminUser);

        Set<Role> userRoles = new HashSet<>(Collections.singleton(userRole));
        User userUser = new User("user", "user", "user", "user", userRoles);
        userService.add(userUser);
    }
}
