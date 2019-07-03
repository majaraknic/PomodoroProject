package eu.execom.pomodoro.service;

import eu.execom.pomodoro.model.Pomodoro;
import eu.execom.pomodoro.repository.PomodoroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PomodoroService {

    @Autowired
    private PomodoroRepository pomodoroRepository;

    public List<Pomodoro> getAll() { return pomodoroRepository.findAll(); }

    public Pomodoro getById(Long id) { return pomodoroRepository.getOne(id); }

    public Pomodoro save(Pomodoro pomodoro) {
        Pomodoro savedPomodoro = pomodoroRepository.save(pomodoro);
        return savedPomodoro;
    }

    public void delete(Long id) {
//        if (!pomodoroRepository.existsById(id)) {
//
//        }
        pomodoroRepository.deleteById(id);
    }
}
