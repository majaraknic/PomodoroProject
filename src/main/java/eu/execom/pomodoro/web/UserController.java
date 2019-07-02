package eu.execom.pomodoro.web;

import eu.execom.pomodoro.model.User;
import eu.execom.pomodoro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/ping")
    public ResponseEntity<User> ping() {
        User user = new User();
        user.setEmail("maja@execom.eu");
        user.setFullName("Maja Katarina Raknic");
        User result = userService.save(user);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/ping")
    public ResponseEntity<User> getById(@RequestParam Long id) {
        User user = userService.getById(id);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
