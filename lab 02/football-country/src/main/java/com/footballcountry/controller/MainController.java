package com.footballcountry.controller;

import com.footballcountry.model.CompetitionDateChoose;
import com.footballcountry.model.countrydata.Country;
import com.footballcountry.model.footballdata.competition.Competition;
import com.footballcountry.model.footballdata.match.Match;
import com.footballcountry.model.footballdata.scorers.Scorer;
import com.footballcountry.service.CountryDataService;
import com.footballcountry.service.FootballDataService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    private final FootballDataService footballDataService;
    private final CountryDataService countryDataService;

    public MainController(FootballDataService footballDataService, CountryDataService countryDataService) {
        this.footballDataService = footballDataService;
        this.countryDataService = countryDataService;
    }

    @GetMapping("/")
    public String sendForm(Model model, CompetitionDateChoose competitionDateChoose) throws Exception {
        List<Competition> availableCompetitions = footballDataService.getAvailableCompetitions();
        model.addAttribute("competitions", availableCompetitions);
        return "competitionDateChoose";
    }

    @PostMapping("/")
    public String processForm(Model model, CompetitionDateChoose competitionDateChoose) throws Exception {
        Date date = competitionDateChoose.getDate();
        String competitionId = competitionDateChoose.getCompetitionId();
        List<Match> matches = footballDataService.getMatchesForCompetition(competitionId, date);
        double averageDouble = footballDataService.getAverageGoalPerMatch(matches);
        List<Scorer> scorers = getScorers(competitionId);
        Competition competition = footballDataService.getCompetitionById(competitionId).get();

        Country country = countryDataService.getCountryByName(competition.getArea().getName());

        model.addAttribute("matches", matches);
        model.addAttribute("average", averageDouble);
        model.addAttribute("scorers", scorers);
        model.addAttribute("competition", competition);
        model.addAttribute("country", country);
        return "showMessage";
    }

    @RequestMapping(value = "/takecurrency", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String greeting(@RequestParam(value = "targetCurrency") String targetCurrency,
                           @RequestParam(value = "startDate") String startDate,
                           @RequestParam(value = "baseCurrency") String baseCurrency) {
        return "a";
    }


    private List<Scorer> getScorers(String competitionId) throws Exception {
        List<Scorer> scorers = footballDataService.getScorersForCompetition(competitionId);
        sortScorers(scorers);
        return scorers;
    }

    private void sortScorers(List<Scorer> scorers) {
        Comparator<Scorer> scorerComparator = Comparator.comparingInt(scorer -> Integer.parseInt(scorer.getNumberOfGoals()));
        scorers.sort(scorerComparator.reversed());
    }


}