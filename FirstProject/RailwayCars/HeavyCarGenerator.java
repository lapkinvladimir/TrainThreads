package FirstProject.RailwayCars;

import java.util.Random;

public class HeavyCarGenerator {

    private static String[] types = {"steel", "iron", "copper", "lead", "aluminum", "nickel", "zinc", "silver", "gold", "platinum", "tungsten", "cobalt", "manganese", "tin", "magnesium", "palladium"};


    public static String generateRandomHeavyCarType() {
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }
}
