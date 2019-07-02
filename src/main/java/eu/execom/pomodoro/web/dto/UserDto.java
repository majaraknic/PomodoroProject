package eu.execom.pomodoro.web.dto;

import eu.execom.pomodoro.model.Pomodoro;
import eu.execom.pomodoro.model.Team;

import javax.persistence.*;
import java.util.List;

public class UserDto {

    private Long id;


    private String email;


    private String fullName;

    private String password;


    private List<Team> teams;


    private List<Pomodoro> pomodoros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Pomodoro> getPomodoros() { return pomodoros; }

    public void setPomodoros(List<Pomodoro> pomodoros) { this.pomodoros = pomodoros; }

}
