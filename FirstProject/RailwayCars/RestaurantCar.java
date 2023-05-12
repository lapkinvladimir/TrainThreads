package FirstProject.RailwayCars;

import FirstProject.Execptions.OverloadException;
import FirstProject.HeavyCars.ToxicCarGenerator;
import FirstProject.Interfaces.Electricity;
import FirstProject.RailwayCars.RailwayCar;

import java.util.Random;

public class RestaurantCar extends RailwayCar implements Electricity {

    private int id;
    private static int nextId = 1;
    private int maxLoadWeight;
    private int weight;
    private int currentWeight;


    public RestaurantCar(String shipper, boolean safetyInfo, double netWeight, double grossWeight, int numOfSeats,
                         String productionDate, String condition, int maxLoadWeight, int weight, int currentWeight) {
        super(shipper, safetyInfo, netWeight, grossWeight, numOfSeats, productionDate, condition);
        this.id = nextId;
        nextId++;
        this.maxLoadWeight = maxLoadWeight;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }


    public int getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public void setMaxLoadWeight(int maxLoadWeight) {
        this.maxLoadWeight = maxLoadWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Override
    public boolean isElectricityOn() {
        return true;
    }

    public void load(){
        Random rand = new Random();
        String cargoName = RestaurantCarGenerator.generateRandomRestaurantCarType();
        weight += rand.nextInt(100) + 1;
        currentWeight += weight;
        try {
            if (currentWeight > maxLoadWeight) {
                throw new OverloadException("Cargo limit reached!");
            }
            System.out.println("Loading " + currentWeight + " kg of " + "(" + cargoName + ") into cargo car #" + this.id);
        } catch (OverloadException e) {
            System.out.println(e.getMessage());
            System.out.println("Cargo car #" + id + ": Current weight: " + currentWeight + " kg");
        }
        System.out.println("Cargo car #" + id + ": Current weight: " + currentWeight + " kg");
    }



    @Override
    public void unload() {
        unload(0);
    }

    public void unload(int weight) {
        if (weight == 0) {
            System.out.println("Nothing to unload from cargo car #" + this.id);
        } else {
            System.out.println("Unloading " + weight + " from cargo car #" + this.id);
            currentWeight = currentWeight - weight;
        }
        System.out.println("Cargo car #" + id + ": Current weight: " + currentWeight + " kg");
    }



    @Override
    public String toString() {
        return "Restaurant car #" + id +
                "\n  Shipper: " + getShipper() +
                "\n  Safety information available: " + isSafetyInfo() +
                "\n  Net weight: " + getNetWeight() + " kg" +
                "\n  Gross weight: " + getGrossWeight() + " kg" +
                "\n  Number of seats: " + getNumOfSeats() +
                "\n  Production date: " + getProductionDate() +
                "\n  Condition: " + getCondition() +
                "\n  Maximum load weight: " + getMaxLoadWeight() + " kg" +
                "\n  Added weight: " + getWeight() + " kg" +
                "\n  Current weight: " + getCurrentWeight() + " kg";
    }

}
