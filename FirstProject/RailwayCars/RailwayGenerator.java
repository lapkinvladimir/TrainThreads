package FirstProject.RailwayCars;

import java.util.Random;

public class RailwayGenerator {

    private static String[] types = {"grains", "poultry", "eggs", "nuts", "cheese", "yogurt", "meat", "fish", "vegetables", "fruits", "dairy products", "flour", "sugar", "salt", "spices", "oil", "water", "beverages", "alcoholic beverages", "ice", "seafood"};


    public static String generateRandomRailwayType() {
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }
}
