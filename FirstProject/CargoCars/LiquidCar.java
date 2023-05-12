package FirstProject.CargoCars;

import java.util.Random;

public class LiquidCar extends CargoCar {

    private int id;
    private static int nextId = 1;
    private String liquidType;
    private int danger = 0;
    private int currentLiters;
    private int liters;
    private int maxLiters;

    public LiquidCar(String shipper, boolean safetyInfo, double netWeight, double grossWeight, int numOfSeats, String productionDate, String condition,
                     int temperature, int maxTemperature, String liquidType, int currentLiters, int liters, int maxLiters) {
        super(shipper, safetyInfo, netWeight, grossWeight, numOfSeats, productionDate, condition, temperature, maxTemperature);
        this.id = nextId;
        this.liquidType = liquidType;
        this.currentLiters = currentLiters;
        this.liters = liters;
        this.maxLiters = maxLiters;
        nextId++;
    }

    public String getLiquidType() {
        return liquidType;
    }

    public int getDanger() {
        return danger;
    }

    public int getLiters() {
        return currentLiters;
    }

    public void setLiquidType(String liquidType) {
        this.liquidType = liquidType;
    }

    public void setDanger(int danger) {
        this.danger = danger;
    }

    public int getCurrentLiters() {
        return currentLiters;
    }

    public void setCurrentLiters(int currentLiters) {
        this.currentLiters = currentLiters;
    }

    public void setLiters(int liters) {
        this.liters = liters;
    }

    public int getMaxLiters() {
        return maxLiters;
    }

    public void setMaxLiters(int maxLiters) {
        this.maxLiters = maxLiters;
    }

    public void checkDanger() {
        if (liquidType.toLowerCase().contains("nitroglycerin")) {
            danger = 1;
            System.out.println("Level of danger: " + danger);
        }
    }


    @Override
    public boolean isElectricityOn() {
        return false;
    }

    public void load() {
        Random rand = new Random();
        String cargoName = LiquidCarGenerator.generateRandomLiquidType();
        liters += rand.nextInt(100) + 1;
        currentLiters += liters;
        if (currentLiters > maxLiters) {
            System.out.println("Cargo limit reached!");
        } else {
            System.out.println("Loading " + liters + " liters of " + "(" + cargoName + ") into cargo car #" + this.id);
        }
        System.out.println("Cargo car #" + id + ": Current weight: " + currentLiters + " liters");
    }



    @Override
    public void unload() {
        unload(0);
    }

    public void unload(int liters) {
        if (liters == 0) {
            System.out.println("Nothing to unload from cargo car #" + this.id);
        } else {
            System.out.println("Unloading " + liters + " from cargo car #" + this.id);
            currentLiters = currentLiters - liters;
        }
        System.out.println("Cargo car #" + id + ": Current weight: " + currentLiters + " liters");
    }



    @Override
    public String toString() {
        return "Liquid car #" + id +
                ":\n  Liquid type: " + liquidType +
                "\n  Level of danger: " + danger +
                "\n  Current amount of liquid: " + currentLiters + " liters" +
                "\n  Maximum amount of liquid: " + maxLiters + " liters" +
                "\n  Added liters " + liters + " liters" +
                "\n  Shipper: " + getShipper() +
                "\n  Safety information available: " + isSafetyInfo() +
                "\n  Net weight: " + getNetWeight() + " kg" +
                "\n  Gross weight: " + getGrossWeight() + " kg" +
                "\n  Number of seats: " + getNumOfSeats() +
                "\n  Production date: " + getProductionDate() +
                "\n  Condition: " + getCondition() +
                "\n  Temperature: " + getTemperature() + " C" +
                "\n  Maximum temperature: " + getMaxTemperature() + " C";
    }


}

