import java.util.LinkedList;
import java.util.Queue;

class Pet {
    String name;
    String species;
    int timestamp;

    public Pet(String name, String species, int timestamp) {
        this.name = name;
        this.species = species;
        this.timestamp = timestamp;
    }
}

public class AnimalShelter {
    private Queue<Pet> catQueue;
    private Queue<Pet> dogQueue;
    private int timestamp;

    public AnimalShelter() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
        timestamp = 0;
    }

    public void addPet(String name, String species) {
        Pet pet = new Pet(name, species, timestamp++);
        if (species.equals("cat")) {
            catQueue.offer(pet);
        } else if (species.equals("dog")) {
            dogQueue.offer(pet);
        }
    }

    public void adoptPet(String preferredSpecies) {
        if (preferredSpecies.equals("cat") && !catQueue.isEmpty()) {
            Pet adoptedCat = catQueue.poll();
            System.out.println("Adopted: " + adoptedCat.name + " (Cat)");
        } else if (preferredSpecies.equals("dog") && !dogQueue.isEmpty()) {
            Pet adoptedDog = dogQueue.poll();
            System.out.println("Adopted: " + adoptedDog.name + " (Dog)");
        } else if (!catQueue.isEmpty()) {
            Pet adoptedCat = catQueue.poll();
            System.out.println("Adopted: " + adoptedCat.name + " (Cat)");
        } else if (!dogQueue.isEmpty()) {
            Pet adoptedDog = dogQueue.poll();
            System.out.println("Adopted: " + adoptedDog.name + " (Dog)");
        } else {
            System.out.println("No pets available for adoption.");
        }
    }
}
