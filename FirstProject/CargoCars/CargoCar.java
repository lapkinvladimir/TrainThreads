    package FirstProject.CargoCars;

    import FirstProject.Execptions.MaxTemperatureException;
    import FirstProject.RailwayCars.RailwayCar;

    import java.util.Random;

    public class CargoCar extends RailwayCar {

        private int id;
        private int nextId = 1;

        private int temperature;
        private int maxTemperature;
        private int maxWeight;
        private int currentWeight;
        private int cargoWeight;

        public CargoCar(String shipper, boolean safetyInfo, double netWeight, double grossWeight, int numOfSeats, String productionDate, String condition,
                        int temperature, int maxTemperature) {
            super(shipper, safetyInfo, netWeight, grossWeight, numOfSeats, productionDate, condition);
            this.id = nextId;
            this.temperature = temperature;
            this.maxTemperature = maxTemperature;
            nextId++;
        }

        public int getTemperature() {
            return temperature;
        }

        public int getMaxTemperature() {
            return maxTemperature;
        }

        public void setMaxTemperature(int maxTemperature) {
            this.maxTemperature = maxTemperature;
        }

        @Override
        public int getMaxWeight() {
            return maxWeight;
        }

        @Override
        public void setMaxWeight(int maxWeight) {
            this.maxWeight = maxWeight;
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

        public void setTemperature(int temperature) throws MaxTemperatureException {
            this.temperature = temperature;
            int delta = (int) (Math.random() * 21) - 10;
            int newTemperature = temperature + delta;
            if (newTemperature > maxTemperature) {
                throw new MaxTemperatureException("Temperature exceeds maximum temperature!");
            } else {
                temperature = newTemperature;
            }
        }

        @Override
        public boolean isElectricityOn() {
            return false;
        }



        public void load() {
            Random rand = new Random();
            String cargoName = CargoTypeGenerator.generateRandomCargoType();
                cargoWeight += rand.nextInt(100) + 1;
                currentWeight += cargoWeight;
                if (currentWeight > getMaxWeight()) {
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
            return "Cargo car #" + id +
                    ":\n  Maximum weight: " + maxWeight + " kg" +
                    "\n  Current weight: " + currentWeight + " kg" +
                    "\n  Added cargo weight: " + cargoWeight + " kg" +
                    "\n  Shipper: " + getShipper() +
                    "\n  Safety information available: " + isSafetyInfo() +
                    "\n  Net weight: " + getNetWeight() + " kg" +
                    "\n  Gross weight: " + getGrossWeight() + " kg" +
                    "\n  Number of seats: " + getNumOfSeats() +
                    "\n  Production date: " + getProductionDate() +
                    "\n  Condition: " + getCondition() +
                    "\n  Temperature: " + temperature + " C" +
                    "\n  Maximum temperature: " + maxTemperature + " C";
        }


    }

