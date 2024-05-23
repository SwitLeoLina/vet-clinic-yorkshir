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
                /*System.out.println("Do you want to add your pet right now? (Y / N)");
                String input = Main.SCANNER.nextLine();
                if(input.equals("Y")) {
                 */

                registerPets(client);
                System.out.println(client);

                }

            }
        }
    private void registerPets(Client client) {
        boolean continueAddPets = true;
        while (continueAddPets) {
            addPet(client);
            System.out.println("Do you want to add more pets for this client? (y/n)");
            String answer = Main.SCANNER.nextLine();
            if("n".equals(answer)) {
                continueAddPets = false;
            }
        }
    }

    private void addPet(Client client) {
        System.out.println("Adding a new pet.");

        Pet pet = petService.registerNewPet();

        if(pet != null) {
            client.addPet(pet);
            pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
            System.out.println("Pet has been added.");
        }
    }

    }
