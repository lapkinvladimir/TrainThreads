package FirstProject.RailwayCars;

import FirstProject.CargoCars.CargoTypeGenerator;
import FirstProject.Execptions.MaxNumElectric;
import FirstProject.Execptions.RailroadHazard;
import FirstProject.Execptions.MaxWagonsException;
import FirstProject.Execptions.OverloadException;
import FirstProject.Interfaces.Electricity;
import FirstProject.Interfaces.Loading;
import FirstProject.Interfaces.Unloading;

import java.util.*;

public class Locomotive implements Electricity, Loading, Unloading {

    public static HashMap<Integer, Locomotive> locomotiveHashMap = new HashMap<>();
    private int id;
    private double percentage;
    private static int nextId = 1;
    private int maxNumOfWagons;
    private int maxWeightCapacity;
    private int maxNumOfWagonsToConnectToPower;
    private String name;
    private String baseStation;
    private String sourceStation;
    private String destinationStation;
    private double speed;
    private int maxNumOfCars;
    private final double MaxSpeed;
    private int currentWeight;
    private int cargoWeight;

    private boolean isForwardDirection = true;
    private ArrayList<RailwayCar> cars = new ArrayList<>();
    private int maxSize;
    private String fuelType;
    private int fuelLevel;

    public Locomotive(int maxNumOfWagons, int maxWeightCapacity, int maxNumOfWagonsToConnectToPower,
                      String name, String baseStation, String sourceStation, String destinationStation, double speed, double MaxSpeed, String fuelType, int fuelLevel) {
        this.id = nextId;
        this.maxNumOfWagons = maxNumOfWagons;
        this.maxWeightCapacity = maxWeightCapacity;
        this.maxNumOfWagonsToConnectToPower = maxNumOfWagonsToConnectToPower;
        this.name = name;
        this.baseStation = baseStation;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.speed = speed;
        this.MaxSpeed = MaxSpeed;
        this.fuelType = fuelType;
        this.fuelLevel = fuelLevel;
        nextId++;
        locomotiveHashMap.put(this.id, this);
    }

    public int getMaxNumOfWagons() {
        return maxNumOfWagons;
    }

    public int getMaxWeightCapacity() {
        return maxWeightCapacity;
    }

    public int getMaxNumOfWagonsToConnectToPower() {
        return maxNumOfWagonsToConnectToPower;
    }

    public String getName() {
        return name;
    }

    public String getBaseStation() {
        return baseStation;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public double getSpeed() {
        return speed;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setMaxNumOfWagons(int maxNumOfWagons) {
        this.maxNumOfWagons = maxNumOfWagons;
    }

    public void setMaxWeightCapacity(int maxWeightCapacity) {
        this.maxWeightCapacity = maxWeightCapacity;
    }

    public void setMaxNumOfWagonsToConnectToPower(int maxNumOfWagonsToConnectToPower) {
        this.maxNumOfWagonsToConnectToPower = maxNumOfWagonsToConnectToPower;
    }

    public boolean getIsForwardDirection() {
        return isForwardDirection;
    }

    public void setForwardDirection(boolean forwardDirection) {
        isForwardDirection = forwardDirection;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseStation(String baseStation) {
        this.baseStation = baseStation;
    }

    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setSpeed(double speed) throws RailroadHazard {
        if (speed > MaxSpeed) {
            throw new RailroadHazard("Max speed exceeded!\n" + this);
        }
        this.speed = speed;
    }

    public double getMaxSpeed() {
        return MaxSpeed;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public ArrayList<RailwayCar> getCars() {
        return cars;
    }

    public void setCars(ArrayList<RailwayCar> cars) {
        this.cars = cars;
    }

    public void setMaxNumOfCars(int maxNumOfCars) {
        this.maxNumOfCars = maxNumOfCars;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public int getMaxNumOfCars() {
        return maxNumOfCars;
    }

    public void changeSpeed() throws RailroadHazard {
        double randomFactor = Math.random() * 0.06 - 0.03;
        double speedChange = speed * randomFactor;
        this.setSpeed(this.speed + speedChange);
    }

    public void refuel(int amount) {
        fuelLevel += amount;
        System.out.println("Refueled with " + amount + " units of fuel. Current fuel level: " + fuelLevel);
    }

    public void consumeFuel(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount of fuel to consume.");
            return;
        }
        if (fuelLevel >= amount) {
            fuelLevel -= amount;
            System.out.println("Consumed " + amount + " units of fuel. Current fuel level: " + fuelLevel);
        } else {
            System.out.println("Not enough fuel to consume.");
        }
    }

    public void addRailwayCar(RailwayCar car) {


        try {
            if (cars.size() < maxNumOfWagons) {
                if (car != null) {
                    int numOfElectricCars = 0;
                    for (RailwayCar c : cars) {
                        if (c.isElectricityOn()) {
                            numOfElectricCars++;
                        }
                    }
                    if (numOfElectricCars < maxNumOfWagonsToConnectToPower) {
                        if (this.currentWeight + car.getCurrentWeight() < this.maxWeightCapacity) {
                            this.currentWeight += car.getCurrentWeight();
                            cars.add(car);
                        } else {
                            throw new OverloadException("Overweight");
                        }
                    } else {
                        throw new MaxNumElectric("Maximum number of electric railway cars reached!");
                    }
                } else {
                    System.out.println("it is null wagon");
                }


            } else {
                throw new MaxWagonsException("Maximum number of railway cars reached!");
            }
        } catch (MaxWagonsException e) {
            System.out.println(e.getMessage());
        } catch (MaxNumElectric e) {
            System.out.println(e.getMessage());
        } catch (OverloadException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeRailwayCar(RailwayCar car) {
        if (cars.contains(car)) {
            cars.remove(car);
        } else {
            System.out.println("The specified railway car is not connected to the locomotive.");
        }
    }

    public void connectToElectricity() {
        int electricCars = 0;
        for (RailwayCar car : cars) {
            if (car.isElectricityOn()) {
                electricCars++;
            }
        }
        if (electricCars > maxNumOfWagonsToConnectToPower) {
            System.out.println("Maximum number of electric railway cars reached!");
        } else {
            System.out.println("Successfully connected " + electricCars + " railway cars to electricity.");
        }
    }


    public void sortList() {
        cars.sort(new Comparator<RailwayCar>() {
            @Override
            public int compare(RailwayCar o1, RailwayCar o2) {
                return o1.getCurrentWeight() - o2.getCurrentWeight();
            }
        });
    }

    @Override
    public boolean isElectricityOn() {
        return false;
    }

    public void load() {
        Random rand = new Random();
        String cargoName = LocomotiveGenerator.generateRandomHeavyCarType();
        cargoWeight += rand.nextInt(100) + 1;
        currentWeight += cargoWeight;
        if (currentWeight > maxWeightCapacity) {
            System.out.println("Cargo limit reached!");
        } else {
            System.out.println("Loading " + cargoWeight + " kg of " + "(" + cargoName + ") into cargo car #" + this.id);
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
        return "Locomotive #" + id +
                ":\n  Maximum number of wagons: " + maxNumOfWagons +
                "\n  Maximum weight capacity: " + maxWeightCapacity + " kg" +
                "\n  Maximum number of wagons to connect to power: " + maxNumOfWagonsToConnectToPower +
                "\n  Name: " + name +
                "\n  Base station: " + baseStation +
                "\n  Source station: " + sourceStation +
                "\n  Destination station: " + destinationStation +
                "\n  Speed: " + speed + " km/h" +
                "\n  Max speed: " + MaxSpeed + " km/h" +
                "\n  Fuel type: " + fuelType +
                "\n  Fuel level: " + fuelLevel + " units" +
                "\n  Added weight: " + cargoWeight + " kg" +
                "\n  Current weight: " + currentWeight + " kg" +
                "\n  Added wagons: \n" + cars;
    }

}

