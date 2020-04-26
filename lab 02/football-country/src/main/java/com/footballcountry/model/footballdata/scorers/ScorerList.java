package com.footballcountry.model.footballdata.scorers;

import com.footballcountry.model.footballdata.competition.Competition;
import com.footballcountry.model.footballdata.competition.CompetitionSeason;

import java.util.List;

public class ScorerList {
    private float count;
    Filters FiltersObject;
    Competition CompetitionObject;
    CompetitionSeason season;
    private List<Scorer> scorers;

    public float getCount() {
        return count;
    }

    public Filters getFiltersObject() {
        return FiltersObject;
    }

    public Competition getCompetitionObject() {
        return CompetitionObject;
    }

    public CompetitionSeason getSeason() {
        return season;
    }

    public List<Scorer> getScorers() {
        return scorers;
    }
}
