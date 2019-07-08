package eu.execom.pomodoro.service;

import eu.execom.pomodoro.model.User;
import eu.execom.pomodoro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private User savedUser;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    public User save(User user) {
        savedUser = userRepository.save(user);
        return savedUser;
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityExistsException("User with this id doesn't exist in database.");
        }
        userRepository.deleteById(id);
    }


}
