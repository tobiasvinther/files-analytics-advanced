package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class CharacterAnalytics {

    //exercise 2.1: perhaps an arrayList and then a while loop where we add each homeWorld
    //and then we loop through the arrayList and somehow count each instance of a homeWorld
    //is there a cool way to do it where we don't need to know which home worlds exists beforehand?

    //howManyTatooine - return how many characters are from in Tatooine
    public int howManyFromHomeWorld(ArrayList<Character> list, String targetHomeWorld) {
        int count = 0;
        for(Character character : list) {
            if(character.getHomeWorld().equals(targetHomeWorld)) {
                count++;
            }
        }
        return count;
    }

    //mostCommonSpecies - what is the most common species?
    public String mostCommonSpecies(ArrayList<Character> list) {
        ArrayList<String> speciesTypeList = new ArrayList<>();
        ArrayList<String> allSpeciesList = new ArrayList<>();

        //loop through each character and check if their species is on the list.
        //if it isn't add it to the speciesTypeList
        //this is not used for finding the most common species, just thought it was neat to have
        for(Character character : list) {
            if(!speciesTypeList.contains(character.getSpecies())) {
                speciesTypeList.add(character.getSpecies());
                //System.out.println("Race: " + character.getSpecies());
            }
        }

        for(Character character : list) {
            allSpeciesList.add(character.getSpecies());
        }

        int speciesCount = 0;
        String mostFrequentSpecies = "N/A";
        for(String entry : allSpeciesList) {
            int thisSpeciesCount = Collections.frequency(allSpeciesList, entry);
            if(thisSpeciesCount > speciesCount) {
                speciesCount = thisSpeciesCount;
                mostFrequentSpecies = entry;
            }
        }

        return mostFrequentSpecies;
    }

    //optimized version of the mostCommonSpecies method above
    public String mostCommonSpecies1(ArrayList<Character> list) {

        int speciesCount = 0;
        String mostFrequentSpecies = "N/A";
        for(Character character : list) {
            int thisSpeciesCount = Collections.frequency(list, character.getSpecies());
            if(thisSpeciesCount > speciesCount) {
                speciesCount = thisSpeciesCount;
                mostFrequentSpecies = character.getSpecies();
            }
        }
        return mostFrequentSpecies;
    }


    //howManyAboveAverage - how many characters are above the average mass?
    public int howManyAboveAverage(ArrayList<Character> list) {
        int characterCount = 0;
        int totalWeight = 0;

        //count each character and add their name mass to the total
        for (Character character : list) {
            //if statement to disregard characters with no info on mass
            if (character.getMass() != -1) {
                characterCount++;
                int mass = character.getMass();
                totalWeight += mass;
            }
        }
        int averageMass = totalWeight / characterCount; //calculate average mass
        int aboveAverageCount = 0;

        //go through list to count characters with above average mass
        for (Character character : list) {
            if (character.getMass() > averageMass) {
                aboveAverageCount++;
            }
        }
        return aboveAverageCount;
    }

    //isFemaleTallest(); Are females taller than males on average?
    public boolean areFemalesTaller(ArrayList<Character> list) {
        //int characterCount = 0;
        int totalMaleHeight = 0;
        int totalFemaleHeight = 0;
        int maleCount = 0;
        int femaleCount = 0;

        //count each character and add their name height to the total
        for (Character character : list) {
            //if statement to disregard characters with no info on height
            if (character.getHeight() != -1) {
                //characterCount++;
                if (character.getGender().equals("male")) {
                    maleCount++;
                    int height = character.getHeight();
                    totalMaleHeight += height;

                } else if (character.getGender().equals("female")) {
                        int height = character.getHeight();
                        totalFemaleHeight += height;
                        femaleCount++;
                }
            }
        }
        //working out the averages of each gender
        int averageMaleHeight = totalMaleHeight / maleCount;
        int averageFemaleHeight = totalFemaleHeight / femaleCount;
        System.out.println("Average male height: " + averageMaleHeight);
        System.out.println("Average female height: " + averageFemaleHeight);

        if(averageFemaleHeight > averageMaleHeight) {
            return true;
        } else if(averageFemaleHeight < averageMaleHeight) {
                return false;
             }
            else {
                    System.out.println("Something went wrong");
                    return false;
        }
    }
}

