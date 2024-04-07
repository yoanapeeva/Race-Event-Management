package bg.fmi.web.lab.raceeventmanagement.repository;

import org.springframework.stereotype.Component;

@Component
public class RaceSequence {
    private Integer sequence = 1000;

    public  Integer getNextValue() {
        return sequence++;
    }
}