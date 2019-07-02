package eu.execom.pomodoro.web.dto;

import eu.execom.pomodoro.model.Pomodoro;
import eu.execom.pomodoro.model.Team;
import eu.execom.pomodoro.model.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDto {

    private Long id;


    private String email;


    private String fullName;

    private String password;


    private List<TeamDto> teams;


    private List<PomodoroDto> pomodoros;

    public  UserDto(){
        super();
    };

    public UserDto (User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.fullName = user.getFullName();
//        this.pomodoros = user.getPomodoros().stream().map(PomodoroDto::new).collect(Collectors.toList());
//        this.teams = user.getTeams().stream().map(TeamDto::new).collect(Collectors.toList());
    }

    public User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());;
//        user.setPomodoros(userDto.getPomodoros().stream().map(Pomodoro::new).collect(Collectors.toList());
//        user.setTeams(userDto.getTeams().stream().map(Team::new).collect(Collectors.toList())
        return user;
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

    public List<TeamDto> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDto> teams) {
        this.teams = teams;
    }

    public List<PomodoroDto> getPomodoros() { return pomodoros; }

    public void setPomodoros(List<PomodoroDto> pomodoros) { this.pomodoros = pomodoros; }

}
