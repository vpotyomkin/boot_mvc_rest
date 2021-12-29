package com.jm.boot_mvc.Service;

import com.jm.boot_mvc.models.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAll();

    void delete(Long id);

    Role getById(Long id);
}
