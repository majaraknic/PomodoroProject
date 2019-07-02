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
    public ResponseEntity<UserDto> ping() {
        User user = new User();
        user.setEmail("maja@execom.eu");
        user.setFullName("Maja Katarina Raknic");
        User result = userService.save(user);

        return ResponseEntity.ok(UserDto.from(result));
    }

    @GetMapping
    public ResponseEntity<UserDto> getById(@RequestParam Long id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(UserDto.from(user));
    }
}
