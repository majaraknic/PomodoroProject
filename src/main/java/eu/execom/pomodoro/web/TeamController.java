package eu.execom.pomodoro.web;

import eu.execom.pomodoro.model.Team;
import eu.execom.pomodoro.service.TeamService;
import eu.execom.pomodoro.web.dto.TeamDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/team")
public class TeamController {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamDto>> getAll() {
        List<Team> teams = teamService.getAll();
        List<TeamDto> teamDtos = teams.stream().map(TeamDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(teamDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getById(@PathVariable Long id) {
        Team team = teamService.getById(id);
        return new ResponseEntity(new TeamDto(team), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeamDto> create(@RequestBody TeamDto teamDto) {
        Team team = MODEL_MAPPER.map(teamDto, Team.class);

        Team result = teamService.save(team);

        return new ResponseEntity(new TeamDto(result), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TeamDto> update(@RequestBody TeamDto teamDto) {
        Team team = MODEL_MAPPER.map(teamDto, Team.class);

        Team result = teamService.save(team);

        return new ResponseEntity(new TeamDto(result), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        teamService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
