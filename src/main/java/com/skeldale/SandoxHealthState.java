package main.java.com.skeldale;

import main.java.com.skeldale.comparator.HealthComparator;
import main.java.com.skeldale.model.Pet;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SandoxHealthState {
    public static void main(String[] args) {
        Pet[] petHealth = {
                new Pet(Pet.Emergency),
                new Pet(Pet.Moderate),
                new Pet(Pet.Good),
                new Pet(Pet.Emergency),
                new Pet(Pet.Serious),
                new Pet(Pet.Good),
                new Pet(Pet.Moderate)
        };

        Arrays.sort(petHealth, new HealthComparator());

        for (Pet pet : petHealth) {
            System.out.println(pet.getHealthState());
        }

    }
}
