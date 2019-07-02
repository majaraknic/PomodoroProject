package eu.execom.pomodoro.service;

import eu.execom.pomodoro.model.User;
import eu.execom.pomodoro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User getById(Long id) {
        return userRepository.getOne(id);
    }
}
