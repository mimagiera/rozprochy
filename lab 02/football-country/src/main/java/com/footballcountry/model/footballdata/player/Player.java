package com.footballcountry.model.footballdata.player;

import java.io.Serializable;

public class Player implements Serializable {

    private String id;
    private String name;
    private String firstName;
    private String lastName;
    private String position;
    private String dateOfBirth;
    private String countryOfBirth;
    private String nationality;
    private String role;
    private String lastUpdated;

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                ", nationality='" + nationality + '\'' +
                ", role='" + role + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
