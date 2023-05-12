package FirstProject.RailwayCars;

import FirstProject.Execptions.OverloadException;
import FirstProject.Interfaces.Electricity;
import FirstProject.Interfaces.Loading;
import FirstProject.Interfaces.Unloading;

import java.util.Random;

public abstract class RailwayCar implements Electricity, Loading, Unloading {
    private int id;
    private static int nextId = 1;
    private String shipper;
    private boolean safetyInfo;
    private double netWeight;
    private double grossWeight;
    private int numOfSeats;
    private int MaxWeight;
    private int currentWeight = 0;
    private int weight;
    private String productionDate;
    private String condition;

    public RailwayCar(String shipper, boolean safetyInfo, double netWeight, double grossWeight, int numOfSeats, String productionDate, String condition) {
        this.id = nextId;
        this.shipper = shipper;
        this.safetyInfo = safetyInfo;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
        this.numOfSeats = numOfSeats;
        this.productionDate = productionDate;
        this.condition = condition;
        nextId++;
    }


    public String getShipper() {
        return shipper;
    }

    public boolean isSafetyInfo() {
        return safetyInfo;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public String getCondition() {
        return condition;
    }

    public int getMaxWeight() {
        return MaxWeight;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public void setSafetyInfo(boolean safetyInfo) {
        this.safetyInfo = safetyInfo;
    }

    public void setNetWeight(double netWeight) {
        this.netWeight = netWeight;
    }

    public void setGrossWeight(double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public void setMaxWeight(int maxWeight) {
        MaxWeight = maxWeight;
    }

    public void checkCondition() {
        if (condition.equals("Ok")) {
            System.out.println("The car is in good condition");
        } else if (condition.equals("needs repair")) {
            System.out.println("The car is in need of repair");
        } else {
            System.out.println("Incorrect state of the wagon");
        }
    }

    @Override
    public boolean isElectricityOn() {
        return false;
    }


    public void load() {
        Random rand = new Random();
        String cargoName = RailwayGenerator.generateRandomRailwayType();
        weight += rand.nextInt(100) + 1;
        currentWeight += weight;
        if (currentWeight > getMaxWeight()) {
            System.out.println("Cargo limit reached!");
        } else {
            System.out.println("Loading " + weight + " kg of " + "(" + cargoName + ") into cargo car #" + this.id);
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
        return "Railway car #" + id +
                ":\n Maximum weight: " + getMaxWeight() + " kg" +
                "\n Current weight: " + currentWeight + " kg" +
                "\n Shipper: " + shipper +
                "\n Safety information available: " + safetyInfo +
                "\n Net weight: " + netWeight + " kg" +
                "\n Gross weight: " + grossWeight + " kg" +
                "\n Number of seats: " + numOfSeats +
                "\n Production date: " + productionDate +
                "\n Condition: " + condition +
                "\n Added Weight: " + weight + " kg" +
                "\n Current weight: " + currentWeight + " kg";
    }


}

