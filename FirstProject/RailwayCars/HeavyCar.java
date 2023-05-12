package FirstProject.RailwayCars;

import FirstProject.Execptions.OverloadException;
import FirstProject.HeavyCars.ToxicCarGenerator;

import java.util.Random;

public class HeavyCar extends RailwayCar {

    private int id;
    private static int nextId = 1;
    private int maxLoadWeight;
    private int weight;
    private int currentWeight;

    public HeavyCar(String shipper, boolean safetyInfo, double netWeight, double grossWeight, int numOfSeats, String productionDate, String condition) {
        super(shipper, safetyInfo, netWeight, grossWeight, numOfSeats, productionDate, condition);
        this.id = nextId;
        nextId++;
    }

    public int getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public int getWeight() {
        return weight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setMaxLoadWeight(int maxLoadWeight) {
        this.maxLoadWeight = maxLoadWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean isElectricityOn() {
        return false;
    }

    public void load(){
        Random rand = new Random();
        String cargoName = HeavyCarGenerator.generateRandomHeavyCarType();
        weight += rand.nextInt(100) + 1;
        currentWeight += weight;
        try {
            if (currentWeight > getMaxLoadWeight()) {
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
        return "Heavy car #" + id +
                ":\n  Maximum load weight: " + maxLoadWeight + " kg" +
                "\n  Added weight: " + weight + " kg" +
                "\n  Current weight: " + currentWeight + " kg" +
                "\n  Shipper: " + getShipper() +
                "\n  Safety information available: " + isSafetyInfo() +
                "\n  Net weight: " + getNetWeight() + " kg" +
                "\n  Gross weight: " + getGrossWeight() + " kg" +
                "\n  Number of seats: " + getNumOfSeats() +
                "\n  Production date: " + getProductionDate() +
                "\n  Condition: " + getCondition();

    }

}
