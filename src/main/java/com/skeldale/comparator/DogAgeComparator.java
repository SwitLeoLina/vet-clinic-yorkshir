package main.java.com.skeldale.comparator;

import main.java.com.skeldale.model.Dog;

import java.util.Comparator;

public class DogAgeComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog dog1, Dog dog2) {
        return dog1.getAge() - dog2.getAge();
    }

}
