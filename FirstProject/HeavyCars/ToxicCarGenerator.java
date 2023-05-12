package FirstProject.HeavyCars;

import java.util.Random;

public class ToxicCarGenerator {

    private static String[] types = {"chemicals", "pesticides", "poisons", "waste", "solvents", "acids", "bases", "flammable liquids", "explosives", "radioactive materials", "asbestos", "lead", "mercury", "arsenic", "cyanide"};

    public static String generateRandomToxicCarType() {
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }
}
