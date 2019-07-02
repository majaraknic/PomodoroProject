package eu.execom.pomodoro.web.dto;

import eu.execom.pomodoro.model.User;

import javax.persistence.*;
import java.util.Date;

public class PomodoroDto {


    private Long id;


    private Date startDateTime;


    private String status;


    private User user;

    private User getUser() {
        return user;
    }

    private void setUser(User users) {
        this.user = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
