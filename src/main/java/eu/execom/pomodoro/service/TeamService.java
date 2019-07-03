package eu.execom.pomodoro.service;

import eu.execom.pomodoro.model.Team;
import eu.execom.pomodoro.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Team getById(Long id) {
        return teamRepository.getOne(id);
    }

    public Team save(Team team) {
        Team savedTeam = teamRepository.save(team);
        return savedTeam;
    }

    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

}
