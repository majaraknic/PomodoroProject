package eu.execom.pomodoro.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pomodoro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Date startDateTime;

    @Column
    private String status;

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

