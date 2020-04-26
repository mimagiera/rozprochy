package com.footballcountry.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CompetitionDateChoose {

    private String competitionId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

    public String getCompetitionId() {
        return competitionId;
    }

    public Date getDate() {
        return date;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
