package eu.execom.pomodoro.web;

import eu.execom.pomodoro.model.Pomodoro;
import eu.execom.pomodoro.service.PomodoroService;
import eu.execom.pomodoro.web.dto.PomodoroDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pomodoro")
public class PomodoroController {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    @Autowired
    private PomodoroService pomodoroService;

    @GetMapping
    public ResponseEntity<List<PomodoroDto>> getAll() {
        List<Pomodoro> pomodoros = pomodoroService.getAll();
        List<PomodoroDto> pomodoroDtos = pomodoros.stream().map(PomodoroDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(pomodoroDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PomodoroDto> getById(@PathVariable Long id) {
        Pomodoro pomodoro = pomodoroService.getById(id);
        return new ResponseEntity(new PomodoroDto(pomodoro), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PomodoroDto> create(@RequestBody PomodoroDto pomodoroDto) {
        Pomodoro pomodoro = MODEL_MAPPER.map(pomodoroDto, Pomodoro.class);
        Pomodoro result = pomodoroService.save(pomodoro);

        return new ResponseEntity(new PomodoroDto(result), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PomodoroDto> update(@RequestBody PomodoroDto pomodoroDto) {
        Pomodoro pomodoro = MODEL_MAPPER.map(pomodoroDto, Pomodoro.class);
        Pomodoro result = pomodoroService.save(pomodoro);

        return new ResponseEntity(new PomodoroDto(result), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        pomodoroService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
