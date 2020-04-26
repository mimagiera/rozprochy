package com.footballcountry.model.footballdata.scorers;

import com.footballcountry.model.footballdata.player.Player;
import com.footballcountry.model.footballdata.team.Team;

public class Scorer {
    private Player player;
    private Team team;
    private String numberOfGoals;

    public Player getPlayer() {
        return player;
    }

    public Team getTeam() {
        return team;
    }

    public String getNumberOfGoals() {
        return numberOfGoals;
    }
}
