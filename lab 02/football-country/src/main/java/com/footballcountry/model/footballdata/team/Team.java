package com.footballcountry.model.footballdata.team;

import com.footballcountry.model.footballdata.area.Area;
import com.footballcountry.model.footballdata.competition.Competition;
import com.footballcountry.model.footballdata.player.Player;

import java.io.Serializable;
import java.util.List;

public class Team implements Serializable {

    private String id;
    private Area area;
    private List<Competition> activeCompetitions;
    private String name;
    private String shortName;
    private String tla;
    private String address;
    private String phone;
    private String website;
    private String email;
    private String founded;
    private String clubColors;
    private String venue;
    private List<Player> squad;
    private String lastUpdated;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Player> getSquad() {
        return squad;
    }
}
