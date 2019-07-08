package eu.execom.pomodoro.service;

import eu.execom.pomodoro.model.Team;
import eu.execom.pomodoro.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private Team savedTeam;

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Team getById(Long id) {
        return teamRepository.getOne(id);
    }

    public Team save(Team team) {
        try {
            savedTeam = teamRepository.save(team);
        } catch (EntityExistsException e){
            System.out.println("This entity already exists in database.");
        }
        return savedTeam;
    }

    public void delete(Long id) {
        if (!teamRepository.existsById(id)) {
            throw new EntityExistsException("Team with this id doesn't exist in database.");
        }
        teamRepository.deleteById(id);
    }

}
