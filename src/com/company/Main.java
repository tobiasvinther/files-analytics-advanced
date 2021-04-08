package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File characters = new File("resources/star-wars-lore.csv"); //create a reference to the csv file

        Scanner fileScanner = new Scanner(characters); // create a scanner with the students file as input

        ArrayList<Character> allCharacters = new ArrayList<>();

        //while there is something left to read, continue
        while(fileScanner.hasNext()) {

            String currentString = fileScanner.nextLine(); // a string that holds the current String. We read the file line by line.
            System.out.println(currentString); // print the current string (currentString)

            String[] lineAsArray = currentString.split(";"); //split currentString using ";" as separator indicator

            //create variables for each character datum, assign the from the array and
            // create Character objects from these values. Then add them to the arrayList
            String name = lineAsArray[0];
            int height = tryParse(lineAsArray[1]);
            int mass = tryParse(lineAsArray[2]);
            String hairColor = lineAsArray[3];
            String eyeColor = lineAsArray[4];
            String birthYear = lineAsArray[5];
            String gender = lineAsArray[6];
            String homeWorld = lineAsArray[7];
            String species = lineAsArray[8];
            Character tempCharacter = new Character(name, height, mass, hairColor,
                    eyeColor, birthYear, gender, homeWorld, species);

            allCharacters.add(tempCharacter);

        }

        System.out.println("Total characters: " + allCharacters.size());

        CharacterAnalytics characterAnalytics = new CharacterAnalytics();

        System.out.println("How many from Tatooine: " + characterAnalytics.howManyFromHomeWorld(allCharacters, "Tatooine"));
        System.out.println("How many above average mass: " + characterAnalytics.howManyAboveAverage(allCharacters));
        System.out.println("Are females taller than males on average: " + characterAnalytics.areFemalesTaller(allCharacters));
        System.out.println("Most frequent species: " + characterAnalytics.mostCommonSpecies(allCharacters));
        System.out.println("Most frequent species1: " + characterAnalytics.mostCommonSpecies(allCharacters));

    }

    public static int tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }



}
