package FirstProject.RailwayCars;

import java.util.Random;

public class PostalCarGenerator {

    private static String[] names = {"John", "Sarah", "Emily", "Michael", "Daniel", "Jessica", "David", "Ashley", "Christopher", "Amanda", "William", "Megan", "Matthew", "Nicole", "Taylor", "Victoria", "Andrew", "Lauren", "Elizabeth", "Tyler"};

    private static String[] texts = {"Hi, how are you?", "When are you planning to come?", "Hey there, just checking in!", "Hope you're doing well!", "Looking forward to seeing you soon!", "What's up?", "How's everything going?", "Miss you!", "Just wanted to say hi!", "Take care!", "Have a great day!"};

    private static String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose", "Austin", "Jacksonville", "Fort Worth", "Columbus", "San Francisco", "Charlotte", "Seattle", "Denver", "Washington", "Boston"};

    private static Random rand = new Random();

    public static String getRandomName() {
        return names[rand.nextInt(names.length)];
    }

    public static String getRandomTexts() {
        return texts[rand.nextInt(texts.length)];
    }

    public static String getRandomCity() {
        return cities[rand.nextInt(cities.length)];
    }

}

