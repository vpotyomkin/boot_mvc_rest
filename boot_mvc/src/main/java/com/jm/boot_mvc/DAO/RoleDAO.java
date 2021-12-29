package com.jm.boot_mvc.DAO;

import com.jm.boot_mvc.models.Role;
import java.util.Set;

public interface RoleDAO {
    Set<Role> getAll();

    void delete(Long id);

    Role getById(Long id);
}
