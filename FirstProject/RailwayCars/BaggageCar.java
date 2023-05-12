package FirstProject.RailwayCars;

import FirstProject.HeavyCars.ToxicCarGenerator;


import java.util.Random;

public class BaggageCar extends RailwayCar {

    private int id;
    private static int nextId = 1;
    private int baggage;
    private int maxBaggage;
    private int currentBaggage;


    public BaggageCar(String shipper, boolean safetyInfo, double netWeight, double grossWeight, int numOfSeats, String productionDate, String condition,
                      int baggage, int maxBaggage, int currentBaggage) {
        super(shipper, safetyInfo, netWeight, grossWeight, numOfSeats, productionDate, condition);
        this.id = nextId;
        nextId++;
        this.baggage = baggage;
        this.maxBaggage = maxBaggage;
        this.currentBaggage = currentBaggage;
    }

    public int getCurrentBaggage() {
        return currentBaggage;
    }

    public void setCurrentBaggage(int currentBaggage) {
        this.currentBaggage = currentBaggage;
    }

    public int getBaggage() {
        return baggage;
    }

    public int getMaxBaggage() {
        return maxBaggage;
    }

    public void setBaggage(int baggage) {
        this.baggage = baggage;
    }

    public void setMaxBaggage(int maxBaggage) {
        this.maxBaggage = maxBaggage;
    }

    @Override
    public boolean isElectricityOn() {
        return false;
    }

    public void load() {
        Random rand = new Random();
        String cargoName = BaggageCarGenerator.generateRandomBaggageCarType();
        baggage += rand.nextInt(100) + 1;
        currentBaggage += baggage;
        if (currentBaggage > maxBaggage) {
            System.out.println("Cargo limit reached!");
        } else {
            System.out.println("Loading " + currentBaggage + " number of bags " + "(" + cargoName + ") into cargo car #" + this.id);
        }
        System.out.println("Cargo car #" + id + ": Current number of bags: " + currentBaggage);
    }



    @Override
    public void unload() {
        unload(0);
    }

    public void unload(int baggage) {
        if (baggage == 0) {
            System.out.println("Nothing to unload from cargo car #" + this.id);
        } else {
            System.out.println("Unloading " + baggage + " from cargo car #" + this.id);
            currentBaggage = currentBaggage - baggage;
        }
        System.out.println("Cargo car #" + id + ": Number of bags: " + currentBaggage);
    }



    @Override
    public String toString() {
        return "Baggage car #" + id +
                ":\n  Current number of bags: " + currentBaggage +
                "\n  Maximum number of bags: " + maxBaggage +
                "\n  Added number of baggage: " + baggage +
                "\n  Shipper: " + getShipper() +
                "\n  Safety information available: " + isSafetyInfo() +
                "\n  Net weight: " + getNetWeight() + " kg" +
                "\n  Gross weight: " + getGrossWeight() + " kg" +
                "\n  Number of seats: " + getNumOfSeats() +
                "\n  Production date: " + getProductionDate() +
                "\n  Condition: " + getCondition();
    }

}