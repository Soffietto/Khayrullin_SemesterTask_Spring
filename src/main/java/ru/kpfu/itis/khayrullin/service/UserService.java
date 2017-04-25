package ru.kpfu.itis.khayrullin.service;

import ru.kpfu.itis.khayrullin.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    User findOneById(Long id);

    List<User> getAll();
}
