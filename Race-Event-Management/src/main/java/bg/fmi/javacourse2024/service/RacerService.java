package bg.fmi.javacourse2024.service;

import bg.fmi.javacourse2024.model.Racer;
import bg.fmi.javacourse2024.repository.RaceSequence;
import bg.fmi.javacourse2024.repository.RacerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * While implementing all functions you can introduce additional functionalities inside the bg.fmi.javacourse2024.repository class
 */
public class RacerService {
    private final RacerRepository racerRepository; // in the future will be injected by the Spring

    @Autowired
    public RacerService(RacerRepository repository) {
        this.racerRepository = repository;
    }

    public List<Racer> getAllRacers() {
        return racerRepository.getAllRacers();
    }

    public List<Racer> getAllRacersByFirstName(String firstName) {
        return racerRepository.getAllRacers().stream()
            .filter(racer -> Objects.equals(racer.getFirstName(), firstName))
            .toList(); // this filtering should be leavet to DB - it will be much faster and saves data transfer from the DB.
        // it is highly recommended for the DB to have index by the field by which we are filtering.
    }

    @Autowired
    public void createRacer(String firstName, String lastName, Integer age, RaceSequence raceSequence) {
        racerRepository.createRacer(new Racer(firstName, lastName, age), raceSequence);
    }

    public boolean deleteRacerById(Integer id) {
        return racerRepository.deleteRacerById(id);
    }
}