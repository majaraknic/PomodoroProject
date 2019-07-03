package eu.execom.pomodoro.web.dto;

import eu.execom.pomodoro.model.Team;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamDto {

    private Long id;


    private String name;

    private List<UserDto> userDtos;

    public TeamDto() {
        super();
    }

    public TeamDto(Team team) {
        this.id = team.getId();
        this.name = team.getName();
//        this.userDtos = team.getUsers().stream().map(user -> new UserDto(user)).collect(Collectors.toList());
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

    public List<UserDto> getUserDtos() {
        return userDtos;
    }

    public void setUserDtos(List<UserDto> userDtos) {
        this.userDtos = userDtos;
    }
}
