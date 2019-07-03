package eu.execom.pomodoro.web.dto;

import eu.execom.pomodoro.model.Pomodoro;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class PomodoroDto {


    private Long id;


    private LocalDateTime startDateTime = LocalDateTime.now();


    private String status;


    private Long userId;

    public PomodoroDto() {
        super();
    }

    public PomodoroDto(Pomodoro pomodoro) {
        this.id = pomodoro.getId();
        this.status = pomodoro.getStatus();
        this.userId = pomodoro.getUser().getId();
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
