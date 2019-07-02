package eu.execom.pomodoro.web.dto;

public class TeamDto {


    private Long id;


    private String name;


    private UserDto user;

    public UserDto getUserDto() { return user; }

    public void setUserDto(UserDto user) { this.user = user; }

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
