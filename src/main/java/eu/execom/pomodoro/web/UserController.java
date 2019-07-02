package eu.execom.pomodoro.web;

import eu.execom.pomodoro.model.User;
import eu.execom.pomodoro.service.UserService;
import eu.execom.pomodoro.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> ping(@RequestBody UserDto userDto) {
        User user = new User();
        User result = userService.save(user);

        return new ResponseEntity(new UserDto(result), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<UserDto> getById(@RequestParam Long id) {
        User user = userService.getById(id);
        return new ResponseEntity(new UserDto(user), HttpStatus.OK);
    }
}
