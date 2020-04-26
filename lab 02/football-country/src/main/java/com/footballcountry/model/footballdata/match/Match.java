package com.footballcountry.model.footballdata.match;

import com.footballcountry.model.footballdata.competition.Competition;
import com.footballcountry.model.footballdata.competition.CompetitionSeason;
import com.footballcountry.model.footballdata.team.Team;

import java.io.Serializable;
import java.util.List;

public class Match implements Serializable {

    private String id;
    private Competition competition;
    private CompetitionSeason season;
    private String utcDate;
    private String status;
    private String venue;
    private String matchday;
    private String stage;
    private String group;
    private String lastUpdated;
    private Team homeTeam;
    private Team awayTeam;
    private MatchScore score;
    private List<MatchReferees> referees;

    public Competition getCompetition() {
        return competition;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public MatchScore getScore() {
        return score;
    }

    public String getUtcDate() {
        return utcDate;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id='" + id + '\'' +
                ", competition=" + competition +
                ", season=" + season +
                ", utcDate='" + utcDate + '\'' +
                ", status='" + status + '\'' +
                ", venue='" + venue + '\'' +
                ", matchday='" + matchday + '\'' +
                ", stage='" + stage + '\'' +
                ", group='" + group + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", score=" + score +
                ", referees=" + referees +
                '}';
    }
}
