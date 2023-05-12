package FirstProject.HeavyCars;

import FirstProject.CargoCars.RefrigeratedCarGenerator;
import FirstProject.RailwayCars.HeavyCar;

import java.util.Random;

public class ToxicCar extends HeavyCar {


    private int id;
    private static int nextId = 1;
    private int currentToxicWeight;
    private int maxToxicWeight;
    private int toxicWeight;
    private int ToxicityLevel = 0;
    private boolean protectiveGearRequired;
    private int MaxToxicityLevel = 50;

    public ToxicCar(String shipper, boolean safetyInfo, double netWeight, double grossWeight, int numOfSeats,
                    String productionDate, String condition,int currentToxicWeight, int maxToxicWeight, int toxicWeight) {
        super(shipper, safetyInfo, netWeight, grossWeight, numOfSeats, productionDate, condition);
        this.id = nextId;
        nextId++;
        this.currentToxicWeight = currentToxicWeight;
        this.maxToxicWeight = maxToxicWeight;
        this.toxicWeight = toxicWeight;
    }


    public int getToxicityLevel() {
        return ToxicityLevel;
    }

    public boolean isProtectiveGearRequired() {
        return protectiveGearRequired;
    }

    public int getMaxToxicityLevel() {
        return MaxToxicityLevel;
    }

    public void setToxicityLevel(int ToxicityLevel) {
        this.ToxicityLevel = ToxicityLevel;
        if (ToxicityLevel > 25) {
            protectiveGearRequired = true;
        }
    }

    public void setProtectiveGearRequired(boolean protectiveGearRequired) {
        this.protectiveGearRequired = protectiveGearRequired;
    }

    public int getCurrentToxicWeight() {
        return currentToxicWeight;
    }

    public void setCurrentToxicWeight(int currentToxicWeight) {
        this.currentToxicWeight = currentToxicWeight;
    }

    public int getMaxToxicWeight() {
        return maxToxicWeight;
    }

    public void setMaxToxicWeight(int maxToxicWeight) {
        this.maxToxicWeight = maxToxicWeight;
    }

    public int getToxicWeight() {
        return toxicWeight;
    }

    public void setToxicWeight(int toxicWeight) {
        this.toxicWeight = toxicWeight;
    }

    public void setMaxToxicityLevel(int maxToxicityLevel) {
        MaxToxicityLevel = maxToxicityLevel;
    }

    @Override
    public boolean isElectricityOn() {
        return false;
    }

    public void load() {
        Random rand = new Random();
        String cargoName = ToxicCarGenerator.generateRandomToxicCarType();
        toxicWeight += rand.nextInt(100) + 1;
        currentToxicWeight += toxicWeight;
        if (currentToxicWeight > maxToxicWeight) {
            System.out.println("Cargo limit reached!");
        } else {
            System.out.println("Loading " + currentToxicWeight + " kg of " + "(" + cargoName + ") into cargo car #" + this.id);
        }
        System.out.println("Cargo car #" + id + ": Current weight: " + currentToxicWeight + " kg");
    }



    @Override
    public void unload() {
        unload(0);
    }

    public void unload(int toxicWeight) {
        if (toxicWeight == 0) {
            System.out.println("Nothing to unload from cargo car #" + this.id);
        } else {
            System.out.println("Unloading " + toxicWeight + " from cargo car #" + this.id);
            currentToxicWeight = currentToxicWeight - toxicWeight;
        }
        System.out.println("Cargo car #" + id + ": Current weight: " + currentToxicWeight + " kg");
    }



    @Override
    public String toString() {
        return "Toxic car #" + id +
                "\n  Shipper: " + getShipper() +
                "\n  Safety information available: " + isSafetyInfo() +
                "\n  Net weight: " + getNetWeight() + " kg" +
                "\n  Gross weight: " + getGrossWeight() + " kg" +
                "\n  Number of seats: " + getNumOfSeats() +
                "\n  Production date: " + getProductionDate() +
                "\n  Condition: " + getCondition() +
                "\n  Current toxic weight: " + currentToxicWeight + " kg" +
                "\n  Maximum toxic weight: " + maxToxicWeight + " kg" +
                "\n  Added toxic weight: " + toxicWeight + " kg" +
                "\n  Toxicity level: " + ToxicityLevel +
                "\n  Protective gear required: " + protectiveGearRequired;
    }


}
