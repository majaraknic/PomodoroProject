package eu.execom.pomodoro.web.dto;

import java.util.Date;

public class PomodoroDto {


    private Long id;


    private Date startDateTime;


    private String status;


    private UserDto user;

    private UserDto getUserDto() {
        return user;
    }

    private void setUserDto(UserDto users) {
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
