package com.jm.boot_mvc.DAO;

import com.jm.boot_mvc.models.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getByUsername(String username) {
        return entityManager.createQuery("select u from User u where u.username = :username", User.class).setParameter("username", username).getSingleResult();
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }
}
