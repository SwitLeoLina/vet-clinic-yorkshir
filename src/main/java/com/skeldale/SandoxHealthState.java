package main.java.com.skeldale;


import main.java.com.skeldale.model.Pet;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class SandoxHealthState {
    public static void main(String[] args) {
        Pet[] petHealth = {
                new Pet(Pet.HealthState.Emergency),
                new Pet(Pet.HealthState.Moderate),
                new Pet(Pet.HealthState.Good),
                new Pet(Pet.HealthState.Emergency),
                new Pet(Pet.HealthState.Serious),
                new Pet(Pet.HealthState.Good),
                new Pet(Pet.HealthState.Moderate)
        };

        Arrays.sort(petHealth, new Comparator<Pet>() {
            @Override
            public int compare(Pet p1, Pet p2) {
                return p1.getHealthState().getValueHealth() - p2.getHealthState().getValueHealth();
            }
        });

        for (Pet pet : petHealth) {
            System.out.println(pet.getHealthState());
        }

    }
}
