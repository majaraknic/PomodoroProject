package eu.execom.pomodoro.service;

import eu.execom.pomodoro.exceptions.DataViolationException;
import eu.execom.pomodoro.exceptions.NumberOfCharactersException;
import eu.execom.pomodoro.model.CustomUserDetails;
import eu.execom.pomodoro.model.User;
import eu.execom.pomodoro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);

        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("Username not found.");
        }
        User user = optionalUser.get();

        return new CustomUserDetails(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    public User save(User user) {
        validatePasswordLength(user);
        validateEmailExistence(user);

        return userRepository.save(user);
    }

    private void validateEmailExistence(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DataViolationException("User with this email already exists in database.");
        }
    }

    private void validatePasswordLength(User user) {
        if (user.getPassword().length() < 5) {
            throw new NumberOfCharactersException("Password must have at least 5 characters!");
        }
    }

    public void delete(Long id) {
        checkIfUserExists(id);

        userRepository.deleteById(id);
    }

    private void checkIfUserExists(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityExistsException("User with this id doesn't exist in database.");
        }
    }
}
