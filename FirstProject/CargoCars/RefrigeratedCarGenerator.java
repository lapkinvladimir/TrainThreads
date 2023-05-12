package FirstProject.CargoCars;

import java.util.Random;

public class RefrigeratedCarGenerator {
    private static String[] types = {"meat", "fish", "poultry", "dairy", "fruit", "vegetables", "frozen foods", "ice cream", "juice", "soda", "beer", "wine"};

    public static String generateRandomRefrigeratedType() {
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }
}
