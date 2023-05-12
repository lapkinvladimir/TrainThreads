package FirstProject.CargoCars;

import java.util.Random;

public class LiquidCarGenerator {
    private static String[] types = {"water", "gasoline", "diesel", "kerosene", "oil", "acetone", "ammonia", "bleach", "brine", "ethanol", "glycerol", "isopropyl alcohol", "mercury", "milk", "peroxide", "vinegar"};

    public static String generateRandomLiquidType() {
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }
}
