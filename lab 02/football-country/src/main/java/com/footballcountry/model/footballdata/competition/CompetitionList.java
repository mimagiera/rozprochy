package com.footballcountry.model.footballdata.competition;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CompetitionList {
    private static List<String> freeTierCompetitions = Arrays.asList("2001", "2017", "2021", "2003", "2002", "2015", "2019", "2014", "2016", "2013", "2000", "2018");

    private String count;
    private List<Competition> competitions;

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public List<Competition> getAvailableCompetitions() {
        return competitions.stream()
                .filter(competition -> freeTierCompetitions.contains(competition.getId()))
                .collect(Collectors.toList());
    }

    private static boolean arrayContainsValue(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s.equals(targetValue))
                return true;
        }
        return false;
    }
}
