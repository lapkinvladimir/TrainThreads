package FirstProject.HeavyCars;

import java.util.Random;

public class LiquidToxicGenerator {
    private static String[] types = {"arsenic", "lead", "cadmium", "mercury", "cyanide", "pesticides", "herbicides", "dioxins", "PCBs", "ethylene oxide", "formaldehyde", "asbestos", "benzene", "toluene", "xylene"};

    public static String generateRandomLiquidToxicType() {
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }
}
