package com.footballcountry.service;

import com.footballcountry.dataSource.CountryDataSource;
import com.footballcountry.model.countrydata.Country;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CountryDataService {

    private final static String BASE_URL = "https://restcountries.eu/rest/v2/name/";
    private static final Map<String, String> COUNTRIES_NAMES_MAPPING = Map.of("England", "United Kingdom of Great Britain and Northern Ireland");
    private final CountryDataSource countryDataSource;

    public CountryDataService(CountryDataSource countryDataSource) {
        this.countryDataSource = countryDataSource;
    }

    public Country getCountryByName(String name) {
        String translation = COUNTRIES_NAMES_MAPPING.get(name);
        if (translation != null) {
            name = translation;
        }
        return countryDataSource
                .getCountriesDataSource()
                .getObjectFromJson(BASE_URL + name, Country[].class)
                .map(array -> array[0])
                .orElse(null);
    }
}
