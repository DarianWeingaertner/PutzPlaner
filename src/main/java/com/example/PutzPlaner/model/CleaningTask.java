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
    @GeneratedValue
    private Long id;
    private String bezeichnung;
    private String person;
    private boolean isClean;
    private int daysToClean;

    public CleaningTask(String bezeichnung, String person, boolean isClean, int daysToClean) {
        this.bezeichnung = bezeichnung;
        this.person = person;
        this.isClean = isClean;
        this.daysToClean = daysToClean;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public String getPerson() {
        return person;
    }

    public boolean isClean() {
        return isClean;
    }

    public int getDaysToClean() {
        return daysToClean;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public void setDaysToClean(int daysToClean) {
        this.daysToClean = daysToClean;
    }
}
