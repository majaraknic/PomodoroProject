package eu.execom.pomodoro.web.dto;

import eu.execom.pomodoro.model.User;

import javax.persistence.*;

public class TeamDto {


    private Long id;


    private String name;


    private User user;

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
