package eu.execom.pomodoro.web;

import eu.execom.pomodoro.exceptions.NoEntityException;
import eu.execom.pomodoro.exceptions.NotValidPasswordException;
import eu.execom.pomodoro.exceptions.NumberOfCharactersException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {


    @ExceptionHandler(NumberOfCharactersException.class)
    public ResponseEntity<Map<String, String>> handle(HttpServletRequest request, NumberOfCharactersException ex) {

        return new ResponseEntity<>(Collections.singletonMap("error", ex.getMessage()), HttpStatus.LENGTH_REQUIRED);
    }

    @ExceptionHandler(NotValidPasswordException.class)
    public ResponseEntity<Map<String, String>> handle(HttpServletRequest request, NotValidPasswordException ex) {

        return new ResponseEntity<>(Collections.singletonMap("error", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NoEntityException.class)
    public ResponseEntity<Map<String, String>> handle(HttpServletRequest request, NoEntityException ex) {

        return new ResponseEntity<>(Collections.singletonMap("error", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

}
