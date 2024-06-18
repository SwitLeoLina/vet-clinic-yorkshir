package main.java.com.skeldale.service;

import main.java.com.skeldale.Main;
import main.java.com.skeldale.model.Cat;
import main.java.com.skeldale.model.Dog;
import main.java.com.skeldale.model.Pet;

public class PetService {

    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";

    public Pet registerNewPet() {
        Pet pet = null;

        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();

        if (DOG_TYPE.equals(type) || CAT_TYPE.equals(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);
        }

        return pet;
    }

    private Pet buildPet(String type) {
        Pet pet = type.equals(CAT_TYPE) ? new Cat() : new Dog();
        pet.setType(type);

        System.out.print("Age: ");
        pet.setAge(Main.SCANNER.nextLine());

        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());

        System.out.print("Sex (male / female): ");
        pet.setSex(Main.SCANNER.nextLine());

        if (type.equals(DOG_TYPE)) {
            System.out.print("Size (XS / S / M / L / XL): ");

            Dog.Size size;
            String sizeInput = Main.SCANNER.nextLine();
            try {
                size = Dog.Size.valueOf(sizeInput);
            } catch (IllegalArgumentException e) {
                size = Dog.Size.UNKNOWN;
                System.out.println("Unable to parse value '" + sizeInput + "'. Using default value: " + Dog.Size.UNKNOWN);
            }

            ((Dog) pet).setSize(size);

        }

        System.out.print("Health state (Good / Moderate / Serious / Emergency): ");
        String healthState = Main.SCANNER.nextLine();
        pet.setHealthState(Pet.HealthState.valueOf(healthState));

        return pet;
    }

}
