package FirstProject.RailwayCars;

import java.util.Random;

public class Passenger {
    private String name;
    private String surname;
    private String city;
    private int age;
    private String ticketNumber;

    public Passenger() {
        Random rand = new Random();
        this.name = generateRandomName(rand);
        this.surname = generateRandomSurname(rand);
        this.city = generateRandomCity(rand);
        this.age = generateRandomAge(rand);
        this.ticketNumber = generateRandomTicketNumber(rand);
    }

    private String generateRandomName(Random rand) {
        String[] names = {"Emma", "Liam", "Olivia", "Noah", "Ava", "Ethan", "Isabella", "Lucas", "Mia", "Mason", "Sophia", "Logan", "Charlotte", "Elijah", "Amelia", "Oliver", "Harper", "Jacob", "Evelyn", "Michael"};
        return names[rand.nextInt(names.length)];
    }

    private String generateRandomSurname(Random rand) {
        String[] surnames = {"Smith", "Johnson", "Brown", "Davis", "Garcia", "Wilson", "Anderson", "Miller", "Jackson", "Taylor", "Thomas", "Moore", "Lee", "Perez", "Thompson", "White", "Harris", "Martin", "Lewis", "Young"};
        return surnames[rand.nextInt(surnames.length)];
    }

    private String generateRandomCity(Random rand) {
        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose",
                "Austin", "Jacksonville", "Fort Worth", "Columbus", "San Francisco", "Charlotte", "Indianapolis", "Seattle", "Denver", "Washington"};
        return cities[rand.nextInt(cities.length)];
    }

    private int generateRandomAge(Random rand) {
        return rand.nextInt(80) + 18;
    }

    private String generateRandomTicketNumber(Random rand) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }
}
