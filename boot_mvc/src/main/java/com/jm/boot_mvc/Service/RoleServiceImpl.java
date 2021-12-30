package com.jm.boot_mvc.Service;

import com.jm.boot_mvc.DAO.RoleDAO;
import com.jm.boot_mvc.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private RoleDAO roleDAO;

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public void add(Role role) {
        roleDAO.add(role);
    }

    @Override
    public Set<Role> getAll() {
        return roleDAO.getAll();
    }

    @Override
    public void delete(Long id) {
        roleDAO.delete(id);
    }

    @Override
    public Role getById(Long id) {
        return roleDAO.getById(id);
    }
}
