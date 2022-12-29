package ru.dmkovy.springbootcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmkovy.springbootcrud.model.User;

public interface UserDaoJpa extends JpaRepository<User, Long> {

}
