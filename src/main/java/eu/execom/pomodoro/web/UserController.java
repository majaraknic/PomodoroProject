package eu.execom.pomodoro.web;

import eu.execom.pomodoro.exceptions.NoEntityException;
import eu.execom.pomodoro.exceptions.NotValidPasswordException;
import eu.execom.pomodoro.model.Pomodoro;
import eu.execom.pomodoro.model.User;
import eu.execom.pomodoro.service.PomodoroService;
import eu.execom.pomodoro.service.UserService;
import eu.execom.pomodoro.web.dto.UserDto;
import eu.execom.pomodoro.web.dto.UserRegistrationDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    @Autowired
    private UserService userService;

    @Autowired
    private PomodoroService pomodoroService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<User> users = userService.getAll();
        List<UserDto> userDtos = users.stream().map(UserDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return new ResponseEntity(new UserDto(user), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UserRegistrationDto userRegistrationDto) {
        validatePassword(userRegistrationDto);

        User user = MODEL_MAPPER.map(userRegistrationDto, User.class);

        User createdUser = userService.save(user);
        Pomodoro pomodoro = pomodoroService.createNewPomodoro(createdUser);

        return new ResponseEntity(HttpStatus.OK);
    }

    private void validatePassword(@RequestBody UserRegistrationDto userRegistrationDto) {

        if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getPasswordConfirmation())) {
            throw new NotValidPasswordException("Passwords doesn't match!");
        }
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        User user = MODEL_MAPPER.map(userDto, User.class);
        if (user.getId() != userDto.getId()) {
            throw new NoEntityException("Entity with this id doesn't exist.");
        } else {
            User result = userService.save(user);

            return new ResponseEntity(new UserDto(result), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
