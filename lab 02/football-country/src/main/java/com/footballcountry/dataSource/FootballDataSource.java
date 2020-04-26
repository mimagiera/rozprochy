package com.footballcountry.dataSource;

import com.footballcountry.model.footballdata.competition.Competition;
import com.footballcountry.model.footballdata.competition.CompetitionList;
import com.footballcountry.model.footballdata.match.MatchList;
import com.footballcountry.model.footballdata.scorers.ScorerList;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FootballDataSource {

    public DataSource<CompetitionList> getCompetitionListDataSource() {
        return new DataSource<>();
    }

    public DataSource<MatchList> getMatchListDataSource() {
        return new DataSource<>();
    }

    public DataSource<ScorerList> getScorerListDataSource() {
        return new DataSource<>();
    }

    public DataSource<Competition> getCompetitionDataSource() {
        return new DataSource<>();
    }

}
