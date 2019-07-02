package eu.execom.pomodoro.service;

import eu.execom.pomodoro.model.User;
import eu.execom.pomodoro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User getById(Long id) {
        try {
            return userRepository.getOne(id);
        } catch (Exception e) {
            throw new EntityNotFoundException("Entity with this id doesnt exist in database");
        }
    }
}
