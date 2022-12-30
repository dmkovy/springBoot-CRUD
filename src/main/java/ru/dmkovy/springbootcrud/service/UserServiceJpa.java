package ru.dmkovy.springbootcrud.service;

import ru.dmkovy.springbootcrud.model.User;

import java.util.List;

public interface UserServiceJpa {
    User findById(Long id);
    List<User> findAll();
    void saveUser(User user);
    void deleteById(Long id);
}
