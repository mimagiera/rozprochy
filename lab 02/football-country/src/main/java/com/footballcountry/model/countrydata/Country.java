package com.footballcountry.model.countrydata;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Country implements Serializable {
    private String name;
    private List<String> topLevelDomain;
    private String alpha2Code;
    private String alpha3Code;
    private List<String> callingCodes;
    private String capital;
    private List<String> altSpellings;
    private String region;
    private String subregion;
    private float population;
    private List<String> latlng;
    private String demonym;
    private float area;
    private float gini;
    private List<String> timezones;
    private List<String> borders;
    private String nativeName;
    private String numericCode;
    private List<Map<String, String>> currencies;
    private List<Map<String, String>> languages;
    private Map<String, String> TranslationsObject;
    private String flag;
    private List<Object> regionalBlocs;
    private String cioc;

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", topLevelDomain=" + topLevelDomain +
                ", alpha2Code='" + alpha2Code + '\'' +
                ", alpha3Code='" + alpha3Code + '\'' +
                ", callingCodes=" + callingCodes +
                ", capital='" + capital + '\'' +
                ", altSpellings=" + altSpellings +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                ", population=" + population +
                ", latlng=" + latlng +
                ", demonym='" + demonym + '\'' +
                ", area=" + area +
                ", gini=" + gini +
                ", timezones=" + timezones +
                ", borders=" + borders +
                ", nativeName='" + nativeName + '\'' +
                ", numericCode='" + numericCode + '\'' +
                ", currencies=" + currencies +
                ", languages=" + languages +
                ", TranslationsObject=" + TranslationsObject +
                ", flag='" + flag + '\'' +
                ", regionalBlocs=" + regionalBlocs +
                ", cioc='" + cioc + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public float getPopulation() {
        return population;
    }

    public List<String> getLatlng() {
        return latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public float getArea() {
        return area;
    }

    public float getGini() {
        return gini;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public List<Map<String, String>> getCurrencies() {
        return currencies;
    }

    public List<Map<String, String>> getLanguages() {
        return languages;
    }

    public Map<String, String> getTranslationsObject() {
        return TranslationsObject;
    }

    public String getFlag() {
        return flag;
    }

    public List<Object> getRegionalBlocs() {
        return regionalBlocs;
    }

    public String getCioc() {
        return cioc;
    }
}