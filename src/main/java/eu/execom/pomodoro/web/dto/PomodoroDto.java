package eu.execom.pomodoro.web.dto;

import eu.execom.pomodoro.model.Pomodoro;
import org.springframework.stereotype.Component;

import java.util.Date;

public class PomodoroDto {


    private Long id;


    private Date startDateTime;


    private String status;


    private Long userId;

    public PomodoroDto(Pomodoro pomodoro) {
        this.id = pomodoro.getId();
        this.startDateTime = pomodoro.getStartDateTime();
        this.status = pomodoro.getStatus();
        this.userId = pomodoro.getUser().getId();
    }

//    public  PomodoroDto (Pomodoro pomodoro) {
//        PomodoroDto dto = new PomodoroDto();
//        dto.setId(dto.getId());
//        dto.setStartDateTime(dto.getStartDateTime());
//        dto.setStatus(dto.getStatus());
//        dto.setUserId(dto.getUserId());
//        return dto;
//    }

    public Pomodoro toPomodoro() {
        Pomodoro pomodoro = new Pomodoro();
        pomodoro.setId(id);
        pomodoro.setStartDateTime(startDateTime);
        pomodoro.setStatus(status);
        //pomodoro.setUser(userId);
        return pomodoro;
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
