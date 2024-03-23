package bg.fmi.javacourse2024.repository;

import org.springframework.stereotype.Component;

@Component
public class RaceSequence {
    private Integer sequence = 1000;

    public  Integer getNextValue() {
        return sequence++;
    }
}