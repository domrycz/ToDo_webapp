package model;

import java.time.LocalDate;

public class Activity {
    private Integer id;
    private String aName;
    private LocalDate aDate;

    public Activity(String aName, LocalDate aDate) {
        this.aName = aName;
        this.aDate = aDate;
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

}
