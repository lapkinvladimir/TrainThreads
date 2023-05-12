package FirstProject.HeavyCars;

import java.util.Random;

public class ExplosiveCarGenerator {

    private static String[] types = {"dynamite", "gunpowder", "TNT", "nitroglycerin", "plastic explosives", "ammunition", "detonators", "fuse", "black powder"};

    public static String generateRandomExplosiveCarType() {
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }
}
