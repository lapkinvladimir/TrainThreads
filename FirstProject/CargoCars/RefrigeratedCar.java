package FirstProject.CargoCars;

import FirstProject.Interfaces.Electricity;
import FirstProject.CargoCars.CargoCar;

import java.util.Random;

public class RefrigeratedCar extends CargoCar implements Electricity {

    private int id;
    private static int nextId = 1;
    private boolean humidityControl;
    private int currentWeight;
    private int refrigeratedWeight;
    private int maxRefrigeratedWeight;

    public RefrigeratedCar(String shipper, boolean safetyInfo, double netWeight, double grossWeight, int numOfSeats, String productionDate, String condition,
                           int temperature, int maxTemperature, int currentWeight, int refrigeratedWeight, int maxRefrigeratedWeight) {
        super(shipper, safetyInfo, netWeight, grossWeight, numOfSeats, productionDate, condition, temperature, maxTemperature);
        this.id = nextId;
        this.currentWeight = currentWeight;
        this.refrigeratedWeight = refrigeratedWeight;
        this.maxRefrigeratedWeight = maxRefrigeratedWeight;
        nextId++;
    }

    public boolean isHumidityControl() {
        return humidityControl;
    }

    public void setHumidityControl(boolean humidityControl) {
        this.humidityControl = humidityControl;
    }

    @Override
    public int getCurrentWeight() {
        return currentWeight;
    }

    @Override
    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getRefrigeratedWeight() {
        return refrigeratedWeight;
    }

    public void setRefrigeratedWeight(int refrigeratedWeight) {
        this.refrigeratedWeight = refrigeratedWeight;
    }

    public int getMaxRefrigeratedWeight() {
        return maxRefrigeratedWeight;
    }

    public void setMaxRefrigeratedWeight(int maxRefrigeratedWeight) {
        this.maxRefrigeratedWeight = maxRefrigeratedWeight;
    }

    @Override
    public boolean isElectricityOn() {
        return true;
    }

    public void load() {
        Random rand = new Random();
        String cargoName = RefrigeratedCarGenerator.generateRandomRefrigeratedType();
        refrigeratedWeight += rand.nextInt(100) + 1;
        currentWeight += refrigeratedWeight;
        if (currentWeight > maxRefrigeratedWeight) {
            System.out.println("Cargo limit reached!");
        } else {
            System.out.println("Loading " + currentWeight + " kg of " + "(" + cargoName + ") into cargo car #" + this.id);
            if (cargoName.contains("fruit")) {
                humidityControl = true;
            }
        }
        System.out.println("Cargo car #" + id + ": Current weight: " + currentWeight + " kg");
    }



    @Override
    public void unload() {
        unload(0);
    }

    public void unload(int refrigeratedWeight) {
        if (refrigeratedWeight == 0) {
            System.out.println("Nothing to unload from cargo car #" + this.id);
        } else {
            System.out.println("Unloading " + refrigeratedWeight + " from cargo car #" + this.id);
            currentWeight = currentWeight - refrigeratedWeight;
        }
        System.out.println("Cargo car #" + id + ": Current weight: " + currentWeight + " kg");
    }



    @Override
    public String toString() {
        return "Refrigerated car #" + id +
                ":\n  Current weight: " + currentWeight + " kg" +
                "\n  Added weight: " + refrigeratedWeight + " kg" +
                "\n  Maximum refrigerated weight: " + maxRefrigeratedWeight + " kg" +
                "\n  Humidity control: " + humidityControl +
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


