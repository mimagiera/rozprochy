package com.footballcountry.model.footballdata.match;

import com.footballcountry.model.footballdata.competition.Competition;

import java.util.List;


public class MatchList {

    private String count;
    private Competition competition;
    private List<Match> matches;

    public List<Match> getMatches() {
        return matches;
    }

    public Competition getCompetition() {
        return competition;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
