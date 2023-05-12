package FirstProject.RailwayCars;

import java.util.Random;

public class LocomotiveGenerator {

    private static String[] types = {"steel", "iron", "copper", "aluminum", "nickel", "zinc", "tungsten", "titanium", "carbon fiber", "ceramic matrix composite"};



    public static String generateRandomHeavyCarType() {
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }

}
