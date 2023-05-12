package FirstProject.CargoCars;

import FirstProject.Execptions.MaxPressureException;
import FirstProject.CargoCars.CargoCar;

import java.util.Random;

public class GasCar extends CargoCar {

        private int id;
        private static int nextId = 1;
        private String gasType;
        private int maxPressure;
        private int currentPressure;
        private int currentWeight;
    private int gasWeight;
    private int maxWeight;

    public GasCar(String shipper, boolean safetyInfo, double netWeight, double grossWeight, int numOfSeats, String productionDate, String condition, int temperature,
                  int maxTemperature, int maxWeight, int currentWeight, int gasWeight) {
        super(shipper, safetyInfo, netWeight, grossWeight, numOfSeats, productionDate, condition, temperature, maxTemperature);
        this.id = nextId;
        this.gasType = gasType;
        this.maxPressure = maxPressure;
        this.currentPressure = currentPressure;
        this.currentWeight = currentWeight;
        this.gasWeight = gasWeight;
        this.maxWeight = maxWeight;
        nextId++;
    }

        public String getGasType() {
            return gasType;
        }

        public int getMaxPressure() {
            return maxPressure;
        }

        public int getCurrentPressure() {
            return currentPressure;
        }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getGasWeight() {
        return gasWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setGasType(String gasType) {
            this.gasType = gasType;
        }

        public void setMaxPressure(int maxPressure) {
            this.maxPressure = maxPressure;
        }

        public void setCurrentPressure(int currentPressure) {
            this.currentPressure = currentPressure;
        }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public void setGasWeight(int gasWeight) {
        this.gasWeight = gasWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void checkPressure() throws MaxPressureException {
            if (currentPressure > maxPressure) {
                throw new MaxPressureException("Current pressure exceeds maximum pressure!");
            }
        }

        @Override
        public boolean isElectricityOn() {
            return false;
        }

    public void load() {
        Random rand = new Random();
        String gasName = GasCarGenerator.generateRandomGasType();
        gasWeight += rand.nextInt(100) + 1;
        currentWeight += gasWeight;
        if (currentWeight > maxWeight) {
            System.out.println("Cargo limit reached!");
        } else {
            System.out.println("Loading " + gasWeight + " kg of " + "(" + gasName + ") into cargo car #" + this.id);
        }
        System.out.println("Cargo car #" + id + ": Current weight: " + currentWeight + " kg");
    }



    @Override
    public void unload() {
        unload(0);
    }

    public void unload(int gasWeight) {
        if (gasWeight == 0) {
            System.out.println("Nothing to unload from cargo car #" + this.id);
        } else {
            System.out.println("Unloading " + gasWeight + " from cargo car #" + this.id);
            currentWeight = currentWeight - gasWeight;
        }
        System.out.println("Cargo car #" + id + ": Current weight: " + currentWeight + " kg");
    }



    @Override
    public String toString() {
        return "Gas car #" + id +
                ":\n  Gas type: " + gasType +
                "\n  Maximum pressure: " + maxPressure + " Pa" +
                "\n  Current pressure: " + currentPressure + " Pa" +
                "\n  Current gas weight: " + currentWeight + " kg" +
                "\n  Added gas weight: " + gasWeight + " kg" +
                "\n  Maximum weight: " + maxWeight + " kg" +
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

