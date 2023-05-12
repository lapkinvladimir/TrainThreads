package FirstProject.CargoCars;

import java.util.Random;

public class CargoTypeGenerator {

    private static String[] types = {"vegetables", "fruits", "grains", "meat", "fish", "poultry", "dairy", "nuts", "seeds", "spices", "sugar", "salt", "tea", "coffee", "cocoa", "honey"};

    public static String generateRandomCargoType() {
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }
}


