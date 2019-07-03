package eu.execom.pomodoro.service;

import eu.execom.pomodoro.model.User;
import eu.execom.pomodoro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    public User save(User user) {



        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public void delete(Long id) {
//        if (!userRepository.existsById(id)) {
//
//        }
        userRepository.deleteById(id);
    }


}
