package com.footballcountry.model.footballdata.match;

import java.io.Serializable;

public class MatchTime implements Serializable {

    private String homeTeam;
    private String awayTeam;

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    @Override
    public String toString() {
        return "MatchTime{" +
                "homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                '}';
    }
}
