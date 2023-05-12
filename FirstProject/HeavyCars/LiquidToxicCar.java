package FirstProject.HeavyCars;

import FirstProject.CargoCars.CargoTypeGenerator;
import FirstProject.RailwayCars.HeavyCar;

import java.util.Random;

public class LiquidToxicCar extends HeavyCar {

    private int id;
    private static int nextId = 1;
    private String liquidType;
    private int tankCapacity;
    private int liters;
    private int currentLiters;
    private boolean chemicalEquipment;

    public LiquidToxicCar(String shipper, boolean safetyInfo, double netWeight, double grossWeight, int numOfSeats,
                          String productionDate, String condition, String liquidType, int liters, int currentLiters, int tankCapacity) {
        super(shipper, safetyInfo, netWeight, grossWeight, numOfSeats, productionDate, condition);
        this.id = nextId;
        nextId++;
        this.liquidType = liquidType;
        this.tankCapacity = tankCapacity;
        this.liters = liters;
        this.currentLiters = currentLiters;
    }


    public String getLiquidType() {
        return liquidType;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public int getLiters() {
        return liters;
    }

    public boolean isChemicalEquipment() {
        return chemicalEquipment;
    }

    public int getCurrentLiters() {
        return currentLiters;
    }

    public void setLiquidType(String liquidType) {
        this.liquidType = liquidType;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public void setLiters(int liters) {
        this.liters = liters;
    }

    public void setCurrentLiters(int currentLiters) {
        this.currentLiters = currentLiters;
    }

    @Override
    public boolean isElectricityOn() {
        return false;
    }

    public void load() {
        Random rand = new Random();
        String cargoName = LiquidToxicGenerator.generateRandomLiquidToxicType();
        liters += rand.nextInt(100) + 1;
        currentLiters += liters;
        if (currentLiters > tankCapacity) {
            System.out.println("Cargo limit reached!");
        } else {
            System.out.println("Loading " + liters + " liters of " + "(" + cargoName + ") into cargo car #" + this.id);
            if (cargoName.contains("mercury")) {
                chemicalEquipment = true;
            }
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
        return "Cargo car #" + id +
                "\n  Liquid type: " + liquidType +
                "\n  Tank capacity: " + tankCapacity + " liters" +
                "\n  Current amount of liquid: " + currentLiters + " liters" +
                "\n  Chemical equipment available: " + chemicalEquipment +
                "\n  Shipper: " + getShipper() +
                "\n  Safety information available: " + isSafetyInfo() +
                "\n  Net weight: " + getNetWeight() + " kg" +
                "\n  Gross weight: " + getGrossWeight() + " kg" +
                "\n  Number of seats: " + getNumOfSeats() +
                "\n  Production date: " + getProductionDate() +
                "\n  Condition: " + getCondition();
    }

}
