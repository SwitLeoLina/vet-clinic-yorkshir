package main.java.com.skeldale;

import main.java.com.skeldale.model.Dog;

import java.util.Arrays;
import java.util.Comparator;

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

        Arrays.sort(dogsByAge, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for(Dog dog : dogsByAge) {
            System.out.println(dog.getAge());
        }
    }

}
