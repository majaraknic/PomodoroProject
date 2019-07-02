package eu.execom.pomodoro.web.dto;

import eu.execom.pomodoro.model.Team;

import static org.graalvm.compiler.options.OptionType.User;

public class TeamDto {


    private Long id;


    private String name;

//
//    private List<UserDto> userId;

    public TeamDto(Team team) {
        this.id = team.getId();
        this.name = team.getName();
    }


//    public static TeamDto from(Team team) {
//        TeamDto dto = new TeamDto();
//        dto.setId(team.getId());
//        dto.setName(team.getName());
////        dto.setUserId(dto.getUserId());
//        return dto;
//    }

    public Team toTeam() {
        Team team = new Team();
        team.setId(id);
        team.setName(name);
        //team.setUsers(List<User> userId);
        return team;
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

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
}
