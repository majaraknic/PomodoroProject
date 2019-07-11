package eu.execom.pomodoro.model;

import eu.execom.pomodoro.web.dto.TeamDto;

import javax.persistence.*;

@Entity
public class Team extends TeamDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @ManyToOne
    private User users;

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

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

    public Team() {
        super();
    }

    public Team(Team team) {
        this.id = team.getId();
        this.name = team.getName();
    }
}
