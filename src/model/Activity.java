package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Activity {
    private Integer id;
    private String aName;
    private LocalDate aDate;
    private LocalTime aTime;

    public Activity(String aName, LocalDate aDate, LocalTime aTime) {
        this.aName = aName;
        this.aDate = aDate;
        this.aTime = aTime;
    }
    public Activity() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public LocalDate getaDate() {
        return aDate;
    }

    public void setaDate(LocalDate aDate) {
        this.aDate = aDate;
    }

    public LocalTime getaTime() {
        return aTime;
    }

    public void setaTime(LocalTime aTime) {
        this.aTime = aTime;
    }
}