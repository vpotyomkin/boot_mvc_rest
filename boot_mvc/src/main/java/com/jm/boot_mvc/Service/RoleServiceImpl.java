package com.jm.boot_mvc.Service;

import com.jm.boot_mvc.DAO.RoleDAO;
import com.jm.boot_mvc.models.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
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
