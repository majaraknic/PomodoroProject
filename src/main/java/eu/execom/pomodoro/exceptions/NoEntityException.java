package eu.execom.pomodoro.exceptions;

import javax.persistence.EntityNotFoundException;

public class NoEntityException extends EntityNotFoundException {

    public NoEntityException(String message) {
        super(message);
    }

}
