package eu.execom.pomodoro.web.dto;

import eu.execom.pomodoro.model.Team;
import org.springframework.stereotype.Component;

/* Data transfer object for entity Team */

@Component
public class TeamDto {

    private Long id;

    private String name;

    public TeamDto() {
        super();
    }

    public TeamDto(Team team) {
        this.id = team.getId();
        this.name = team.getName();
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
}
