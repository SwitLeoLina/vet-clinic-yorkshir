package main.java.com.skeldale.comparator;

import main.java.com.skeldale.model.Pet;

import java.util.Comparator;

public class HealthComparator implements Comparator<Pet> {
    @Override
    public int compare(Pet pet1, Pet pet2) {
        return convertHealth(pet1.getHealthState()) - convertHealth(pet2.getHealthState());
    }

    private static int convertHealth(String healthState) {
        return switch (healthState) {
            case Pet.Good -> 4;
            case Pet.Moderate -> 3;
            case Pet.Serious -> 2;
            case Pet.Emergency -> 1;
            default -> 0;
        };

    }

}
