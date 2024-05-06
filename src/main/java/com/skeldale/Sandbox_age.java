package main.java.com.skeldale;

import main.java.com.skeldale.comparator.DogAgeComparator;
import main.java.com.skeldale.model.Dog;

import java.util.Arrays;

public class Sandbox_age {
    public static void main(String[] args) {
        Dog[] dogsByAge = {
                new Dog(3),
                new Dog(6),
                new Dog(1),
                new Dog(12),
                new Dog(2),
                new Dog(35)
        };

        Arrays.sort(dogsByAge, new DogAgeComparator());

        for(Dog dog : dogsByAge) {
            System.out.println(dog.getAge());
        }
    }

}
