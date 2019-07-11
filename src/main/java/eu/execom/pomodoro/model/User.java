package eu.execom.pomodoro.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String fullName;

    @Column
    private String password;

    @ManyToOne
    private Team teams;

    @OneToMany(mappedBy = "user")
    private List<Pomodoro> pomodoros = new ArrayList<>();

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

    public Team getTeams() {
        return teams;
    }

    public void setTeams(Team teams) {
        this.teams = teams;
    }

    public List<Pomodoro> getPomodoros() { return pomodoros; }

    public void setPomodoros(List<Pomodoro> pomodoros) { this.pomodoros = pomodoros; }

    public User() {
        super();
    }

    public User(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.fullName = user.getFullName();
        this.password = user.getPassword();
    }

}