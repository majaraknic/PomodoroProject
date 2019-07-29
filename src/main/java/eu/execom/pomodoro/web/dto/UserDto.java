package eu.execom.pomodoro.web.dto;

import eu.execom.pomodoro.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDto {

    private Long id;

    private String email;

    private String fullName;

    private String password;

//    private TeamDto team;

    private Long teamId;

    public UserDto() {
        super();
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.fullName = user.getFullName();
//        this.team = user.getTeam() == null ? null : new TeamDto(user.getTeam());
        this.teamId = user.getTeam().getId();
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

//    public TeamDto getTeam() {
//        return team;
//    }
//
//    public void setTeam(TeamDto team) {
//        this.team = team;
//    }


    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
