package main.java.com.skeldale.component;

import main.java.com.skeldale.Main;
import main.java.com.skeldale.model.Client;
import main.java.com.skeldale.model.Pet;
import main.java.com.skeldale.service.ClientService;
import main.java.com.skeldale.service.PetService;

import java.util.Scanner;

public class ApplicationRunner {
     private final ClientService clientService = new ClientService();
     private final PetService petService = new PetService();

    public void run() {
        if(Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) {
                System.out.println("Do you want to add your pet right now? (Y / N)");
                String input = Main.SCANNER.nextLine();
                if(input.equals("Y")) {
                    System.out.println("Adding a new pet.");
                    Pet pet = petService.registerNewPet();
                    client.setPet(pet);
                    pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                    System.out.println("Pet has been added.");

                    System.out.println(client);

                }

            }
        }

    }
}
