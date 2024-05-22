package com.example.PutzPlaner.model;

public class CleaningTaskWithId extends CleaningTask{
    private Long id;

    public CleaningTaskWithId(String bezeichnung, String person, boolean isClean, int daysToClean, Long id) {
        super(bezeichnung, person, isClean, daysToClean);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
