package com.example.PutzPlaner;

public class CleaningTask {
    private String personName;
    private String room;
    private boolean isClean;
    private int daysToClean;

    public CleaningTask(String personName, String room, boolean isClean, int daysToClean) {
        this.personName = personName;
        this.room = room;
        this.isClean = isClean;
        this.daysToClean = daysToClean;
    }

    public String getPersonName() {
        return personName;
    }

    public String getRoom() {
        return room;
    }

    public boolean isClean() {
        return isClean;
    }

    public int getDaysToClean() {
        return daysToClean;
    }
}
