package FirstProject.HeavyCars;


import FirstProject.CargoCars.CargoTypeGenerator;
import FirstProject.Execptions.MaxExplosiveAmountExceededException;
import FirstProject.RailwayCars.HeavyCar;

import java.util.Random;

public class ExplosiveCar extends HeavyCar {

    private int id;
    private static int nextId = 1;


    private int maxExplosiveAmount;
    private int currentWeight;
    private int explosiveWeight;
    private int dangerLevel = 0;


    public ExplosiveCar(String shipper, boolean safetyInfo, double netWeight, double grossWeight,
                        int numOfSeats, String productionDate, String condition, int currentWeight,
                        int maxExplosiveAmount, int explosiveWeight) {
        super(shipper, safetyInfo, netWeight, grossWeight, numOfSeats, productionDate, condition);
        this.id = nextId;
        nextId++;
        this. maxExplosiveAmount = maxExplosiveAmount;
        this.currentWeight = currentWeight;
        this.explosiveWeight = explosiveWeight;
    }


    public int getMaxExplosiveAmount() {
        return maxExplosiveAmount;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getExplosiveWeight() {
        return explosiveWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public void setExplosiveWeight(int explosiveWeight) {
        this.explosiveWeight = explosiveWeight;
    }

    public void setMaxExplosiveAmount(int maxExplosiveAmount) {
        this.maxExplosiveAmount = maxExplosiveAmount;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(int dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    @Override
    public boolean isElectricityOn() {
        return false;
    }

    public void load() {
        Random rand = new Random();
        String cargoName = ExplosiveCarGenerator.generateRandomExplosiveCarType();
        explosiveWeight += rand.nextInt(100) + 1;
        currentWeight += explosiveWeight;
        if (currentWeight > maxExplosiveAmount) {
            System.out.println("Cargo limit reached!");
        } else {
            System.out.println("Loading " + explosiveWeight + " kg of " + "(" + cargoName + ") into cargo car #" + this.id);
            if (cargoName.contains("TNT")) {
                dangerLevel = 5;
            } else if (cargoName.contains("detonators")) {
                dangerLevel = 7;
            }
        }
        System.out.println("Cargo car #" + id + ": Current weight: " + currentWeight + " kg");
    }



    @Override
    public void unload() {
        unload(0);
    }

    public void unload(int cargoWeight) {
        if (cargoWeight == 0) {
            System.out.println("Nothing to unload from cargo car #" + this.id);
        } else {
            System.out.println("Unloading " + cargoWeight + " from cargo car #" + this.id);
            currentWeight = currentWeight - cargoWeight;
        }
        System.out.println("Cargo car #" + id + ": Current weight: " + currentWeight + " kg");
    }



    @Override
    public String toString() {
        return "Explosive car #" + id +
                "\n  Danger level: " + dangerLevel +
                "\n  Current weight: " + currentWeight + " kg" +
                "\n  Maximum amount: " + maxExplosiveAmount + " kg" +
                "\n  Added weight: " + explosiveWeight + " kg" +
                "\n  Shipper: " + getShipper() +
                "\n  Safety information available: " + isSafetyInfo() +
                "\n  Net weight: " + getNetWeight() + " kg" +
                "\n  Gross weight: " + getGrossWeight() + " kg" +
                "\n  Number of seats: " + getNumOfSeats() +
                "\n  Production date: " + getProductionDate() +
                "\n  Condition: " + getCondition();
    }

}
