import java.util.Date;
import java.util.HashSet;

public class AnimalHospital {
    private HashSet<Pet> animals;

    public AnimalHospital() {
        animals = new HashSet<>();
    }

    public void registerPet(Pet pet) {
        animals.add(pet);
    }

    void printPetInfoByName(String name) {
        System.out.println("Pets with name = " + name + ":\n");
        for (Pet p: animals) {
            if (p.getPetName().equals(name)) {
                System.out.println(p.toString() + "\n");
            }
        }
    }
    void printPetInfoByOwner(String name) {
        System.out.println(name + "'s pets:\n");
        for (Pet p: animals) {
            if (p.getOwnerName().equals(name)) {
                System.out.println(p.toString() + "\n");
            }
        }
    }
    void printPetsBoarding(int month, int day, int year) {
        System.out.println("Boarding:\n");
        for (Pet p: animals) {
            if (p instanceof Boardable) {
                if (((Boardable)p).boarding(month, day, year)) {
                    System.out.println(p.toString() + "\n");
                }
            }
        }
    }

}
