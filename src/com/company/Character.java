package com.company;

public class Character {

    private String name;
    private int height;
    private int mass;
    private String hairColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeWorld;
    private String species;

    public Character(String name, int height, int mass, String hairColor, String eyeColor, String birthYear,
                     String gender, String homeWorld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeWorld = homeWorld;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public String getSpecies() {
        return species;
    }
}
