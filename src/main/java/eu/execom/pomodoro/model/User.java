package eu.execom.pomodoro.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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