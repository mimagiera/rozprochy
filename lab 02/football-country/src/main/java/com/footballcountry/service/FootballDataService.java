package com.footballcountry.service;

import com.footballcountry.dataSource.FootballDataSource;
import com.footballcountry.model.footballdata.competition.Competition;
import com.footballcountry.model.footballdata.competition.CompetitionList;
import com.footballcountry.model.footballdata.match.Match;
import com.footballcountry.model.footballdata.match.MatchList;
import com.footballcountry.model.footballdata.scorers.Scorer;
import com.footballcountry.model.footballdata.scorers.ScorerList;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@Service
public class FootballDataService {

    private static final String BASE_URL = "http://api.football-data.org/v2/competitions/";
    private final FootballDataSource footballDataSource;

    public FootballDataService(FootballDataSource footballDataSource) {
        this.footballDataSource = footballDataSource;
    }

    public List<Competition> getAvailableCompetitions() {
        return footballDataSource
                .getCompetitionListDataSource()
                .getObjectFromJson(BASE_URL, CompetitionList.class)
                .map(CompetitionList::getAvailableCompetitions)
                .orElse(List.of());
    }

    public List<Match> getMatchesForCompetition(String competitionId) {
        return footballDataSource
                .getMatchListDataSource()
                .getObjectFromJson(BASE_URL + competitionId + "/matches", MatchList.class)
                .map(MatchList::getMatches)
                .orElse(List.of());
    }

    public List<Match> getMatchesForCompetition(String competitionId, Date date) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return getMatchesForCompetition(competitionId)
                .stream().filter(match -> {
                    try {
                        Date matchDate = dateFormat.parse(match.getUtcDate());
                        return DateUtils.isSameDay(matchDate, date);
                    } catch (Exception e) {
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Scorer> getScorersForCompetition(String competitionId) {
        return footballDataSource
                .getScorerListDataSource()
                .getObjectFromJson(BASE_URL + competitionId + "/scorers", ScorerList.class)
                .map(ScorerList::getScorers)
                .orElse(List.of());
    }

    public Optional<Competition> getCompetitionById(String competitionId) {
        return footballDataSource.getCompetitionDataSource()
                .getObjectFromJson(BASE_URL + competitionId, Competition.class);
    }

    public double getAverageGoalPerMatch(List<Match> matches) {
        return matches.stream().map(match -> match.getScore().getFullTime())
                .mapToInt(score -> {
                            try {
                                return parseInt(score.getHomeTeam()) + parseInt(score.getAwayTeam());
                            } catch (Exception e) {
                                return 0;
                            }
                        }
                )
                .average()
                .orElse(0.0d);
    }

}
