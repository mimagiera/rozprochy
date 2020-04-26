package com.footballcountry.model.footballdata.competition;

import com.footballcountry.model.footballdata.area.Area;

import java.io.Serializable;
import java.util.List;

public class Competition implements Serializable {

    private String id;
    private Area area;
    private String name;
    private String code;
    private String plan;
    private CompetitionSeason currentSeason;
    private List<CompetitionSeason> seasons;
    private String lastUpdated;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Area getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id='" + id + '\'' +
                ", area=" + area +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", plan='" + plan + '\'' +
                ", currentSeason=" + currentSeason +
                ", seasons=" + seasons +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }

}
