package ru.dmkovy.springbootcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dmkovy.springbootcrud.dao.UserDaoJpa;
import ru.dmkovy.springbootcrud.model.User;

import java.util.List;

@Service
public class UserServiceJpaImpl implements UserServiceJpa {
    private final UserDaoJpa userDaoJpa;

    @Autowired
    public UserServiceJpaImpl(UserDaoJpa userDaoJpa) {
        this.userDaoJpa = userDaoJpa;
    }

    @Override
    public User findById(Long id) {
        return userDaoJpa.getReferenceById(id);
    }

    @Override
    public List<User> findAll() {
        return userDaoJpa.findAll();
    }

    @Override
    public void saveUser(User user) {
        userDaoJpa.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDaoJpa.deleteById(id);
    }
}
