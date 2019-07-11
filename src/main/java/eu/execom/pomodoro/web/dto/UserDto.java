package eu.execom.pomodoro.web.dto;

import eu.execom.pomodoro.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDto {

    private Long id;


    private String email;


    private String fullName;

    private String password;


    private TeamDto teams;


    private List<PomodoroDto> pomodoros;

    public  UserDto(){
        super();
    };

    public UserDto (User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.fullName = user.getFullName();
        this.pomodoros = user.getPomodoros().stream().map(PomodoroDto::new).collect(Collectors.toList());
        this.teams = user.getTeams();
    }

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

    public TeamDto getTeams() {
        return teams;
    }

    public void setTeams(TeamDto teams) {
        this.teams = teams;
    }

    public List<PomodoroDto> getPomodoros() { return pomodoros; }

    public void setPomodoros(List<PomodoroDto> pomodoros) { this.pomodoros = pomodoros; }

}
