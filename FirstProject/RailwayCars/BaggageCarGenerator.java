package FirstProject.RailwayCars;

import java.util.Random;

public class BaggageCarGenerator {

    private static String[] types = {"luggage", "backpacks", "suitcases", "duffel bags", "carry-ons", "briefcases", "boxes", "packages", "parcels", "shopping bags", "sporting equipment", "musical instruments", "photography equipment"};


    public static String generateRandomBaggageCarType() {
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }
}
