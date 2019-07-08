package eu.execom.pomodoro.model;

import eu.execom.pomodoro.model.enumerations.Status;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pomodoro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private LocalDate startDateTime;

    @Column
    private Status status;

    @ManyToOne
    private User user;

    public Pomodoro() {
        super();
    }

    public Pomodoro(Pomodoro pomodoro) {
        this.id = pomodoro.getId();
        this.startDateTime = pomodoro.getStartDateTime();
        this.status = pomodoro.getStatus();
        this.user = pomodoro.getUser();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User users) {
        this.user = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDate startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}

