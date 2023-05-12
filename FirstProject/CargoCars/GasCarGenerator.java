package FirstProject.CargoCars;

import java.util.Random;

public class GasCarGenerator {
    private static String[] types = {"hydrogen", "helium", "oxygen", "nitrogen", "methane", "carbon dioxide", "neon", "argon", "krypton", "xenon", "radon", "chlorine", "fluorine"};

    public static String generateRandomGasType() {
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }
}
