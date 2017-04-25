package ru.kpfu.itis.khayrullin.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khayrullin.model.User;
import ru.kpfu.itis.khayrullin.repository.UserRepository;
import ru.kpfu.itis.khayrullin.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public User findOneById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
