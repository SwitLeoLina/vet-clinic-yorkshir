package main.java.com.skeldale.component;

import main.java.com.skeldale.Main;
import main.java.com.skeldale.model.Client;
import main.java.com.skeldale.model.Pet;
import main.java.com.skeldale.service.ClientService;
import main.java.com.skeldale.service.PetService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRegister {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void registerClients() {
        List<Client> clients = new ArrayList<>();
        String message = "Do you want to register more clients? (y/n)";
        do {
            Client client = addClient();
            if (client != null) {
                clients.add(client);
            }
        } while (verifyRepeating(message));

        Map<Client.Location, List<Client>> clientsByLocation = groupClients(clients);

        printClients(clientsByLocation);
    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for (Map.Entry<Client.Location, List<Client>> clients : clientsByLocation.entrySet()) {
            String content = "\nLocation: " + clients.getKey()
                    + "\nClients (" + clients.getValue().size() + "):"
                    + "\n\t" + clients.getValue();
            System.out.println(content);

        }
    }

    private Map<Client.Location, List<Client>> groupClients(List<Client> clients) {
        List<Client> fromDnipro = new ArrayList<>();
        List<Client> fromKyiv = new ArrayList<>();
        List<Client> fromLviv = new ArrayList<>();
        List<Client> unknownLocation = new ArrayList<>();

        for (Client client : clients) {
            switch (client.getLocation()) {
                case DNIPRO -> fromDnipro.add(client);
                case KYIV -> fromKyiv.add(client);
                case LVIV -> fromLviv.add(client);
                case UNKNOWN -> unknownLocation.add(client);
            }
        }

        Map<Client.Location, List<Client>> clientsByLocation = new HashMap<>();
        clientsByLocation.put(Client.Location.DNIPRO, fromDnipro);
        clientsByLocation.put(Client.Location.KYIV, fromKyiv);
        clientsByLocation.put(Client.Location.LVIV, fromLviv);
        clientsByLocation.put(Client.Location.UNKNOWN, unknownLocation);

        return clientsByLocation;
    }

    private Client addClient() {
        Client client = clientService.registerNewClient();

        if (client != null) {
                /*System.out.println("Do you want to add your pet right now? (Y / N)");
                String input = Main.SCANNER.nextLine();
                if(input.equals("Y")) {
                 */

            registerPets(client);
            System.out.println(client);
        }
        return client;
    }
    private void registerPets(Client client) {
        String message = "Do you want to add more pets for this client? (y/n)";
        do {
            addPet(client);
        } while (verifyRepeating(message));
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

    private boolean verifyRepeating(String message) {
        System.out.println(message);
        String answer = Main.SCANNER.nextLine();
        if("y".equals(answer)) {
            return true;
        } else if ("n".equals(answer)) {
            return false;
        } else {
            System.out.println("Incorrect answer. Please try again.");
            return verifyRepeating(message);
        }
    }
}
