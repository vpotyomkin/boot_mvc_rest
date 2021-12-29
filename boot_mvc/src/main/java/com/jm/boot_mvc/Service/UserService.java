package com.jm.boot_mvc.Service;

import com.jm.boot_mvc.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void add(User user);

    void delete(Long id);

    void edit(User user);

    User getById(Long id);

    User getByUsername(String username);
}
