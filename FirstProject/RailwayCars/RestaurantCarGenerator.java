package FirstProject.RailwayCars;

import java.util.Random;

public class RestaurantCarGenerator {

    private static String[] types = {"meat", "fish", "vegetables", "fruits", "dairy products", "flour", "sugar", "salt", "spices", "oil", "water", "beverages", "alcoholic beverages", "ice", "seafood"};


    public static String generateRandomRestaurantCarType() {
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }
}
