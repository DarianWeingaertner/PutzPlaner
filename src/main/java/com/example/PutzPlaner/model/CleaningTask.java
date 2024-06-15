package com.example.PutzPlaner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CleaningTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bezeichnung;
    private String person;
    private int daysToClean;

    public CleaningTask(String bezeichnung, String person, int daysToClean) {
        this.bezeichnung = bezeichnung;
        this.person = person;
        this.daysToClean = daysToClean;
    }
}
