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

    @Autowired
    private User savedUser = new User();

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityExistsException("User with this id doesn't exist in database.");
        }

        return userRepository.getOne(id);
    }

    public User save(User user) {

        try {
            savedUser = userRepository.save(user);
        } catch (EntityExistsException e){
            System.out.println("This entity already exists in database.");
        }
        return savedUser;
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityExistsException("User with this id doesn't exist in database.");
        }
        userRepository.deleteById(id);
    }


}
