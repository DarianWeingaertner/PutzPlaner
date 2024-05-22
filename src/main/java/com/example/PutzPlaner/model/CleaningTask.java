package com.example.PutzPlaner.model;

public class CleaningTask {
    private String bezeichung;
    private String person;
    private boolean isClean;
    private int daysToClean;

    public CleaningTask(String bezeichnung, String person, boolean isClean, int daysToClean) {
        this.bezeichung = bezeichnung;
        this.person = person;
        this.isClean = isClean;
        this.daysToClean = daysToClean;
    }

    public String getBezeichung() {
        return bezeichung;
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

    public void setBezeichung(String bezeichung) {
        this.bezeichung = bezeichung;
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
