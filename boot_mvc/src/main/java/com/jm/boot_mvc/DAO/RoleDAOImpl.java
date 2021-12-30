package com.jm.boot_mvc.DAO;

import com.jm.boot_mvc.models.Role;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Repository
public class RoleDAOImpl implements RoleDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Set<Role> getAll() {
        return new HashSet<>(entityManager.createQuery("from Role", Role.class).getResultList());
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public Role getById(Long id) {
        return entityManager.find(Role.class, id);
    }
}
