package eu.execom.pomodoro.web.dto;

import eu.execom.pomodoro.model.User;

import java.util.List;

public class UserDto {

    private Long id;


    private String email;


    private String fullName;

    private String password;


    private List<TeamDto> teams;


    private List<PomodoroDto> pomodoros;

    public static UserDto from(User user) {
        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setId(user.getId());
        dto.setPomodoros(user.getPomodoros());
        dto.setTeams(user.getTeams());
        return dto;
    }

    public User toUser() {
        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setId(id);
        user.setPassword(password);
        user.setPomodoros(pomodoros);
        user.setTeams(teams);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
