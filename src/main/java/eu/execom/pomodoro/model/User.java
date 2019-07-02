package eu.execom.pomodoro.model;

import eu.execom.pomodoro.web.dto.PomodoroDto;
import eu.execom.pomodoro.web.dto.TeamDto;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String email;

    @Column
    private String fullName;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Team> teams;

    @OneToMany(mappedBy = "user")
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

    public List<TeamDto> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDto> teams) {
        this.teams = teams;
    }

    public List<PomodoroDto> getPomodoros() { return pomodoros; }

    public void setPomodoros(List<PomodoroDto> pomodoros) { this.pomodoros = pomodoros; }

}