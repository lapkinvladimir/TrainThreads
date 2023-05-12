package FirstProject.RailwayCars;

import FirstProject.Interfaces.Electricity;

public class PassengerCar extends RailwayCar implements Electricity {

    private int id;
    private static int nextId = 1;
    private Passenger[] passengers;

    public PassengerCar(String shipper, boolean safetyInfo, double netWeight, double grossWeight, int numOfSeats, String productionDate, String condition) {
        super(shipper, safetyInfo, netWeight, grossWeight, numOfSeats, productionDate, condition);
        this.id = nextId;
        nextId++;
        this.passengers = new Passenger[numOfSeats];
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    @Override
    public boolean isElectricityOn() {
        return true;
    }

    @Override
    public void load() {
        for (int i = 0; i < passengers.length; i++) {
            passengers[i] = new Passenger();
        }
    }

    @Override
    public void unload() {
        for (int i = 0; i < passengers.length; i++) {
            passengers[i] = null;
        }
    }

    public void unload(Passenger passenger) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null && passengers[i].equals(passenger)) {
                passengers[i] = null;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Passenger car #" + id +
                ":\n  Shipper: " + getShipper() +
                "\n  Safety information available: " + isSafetyInfo() +
                "\n  Net weight: " + getNetWeight() + " kg" +
                "\n  Gross weight: " + getGrossWeight() + " kg" +
                "\n  Number of seats: " + getNumOfSeats() +
                "\n  Production date: " + getProductionDate() +
                "\n  Condition: " + getCondition() +
                "\n  Passengers in the car: \n" + getPassengerList();
    }

    public String getPassengerList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null) {
                sb.append("    Passenger ").append(i+1).append(": ");
                sb.append(passengers[i].getName()).append(" ");
                sb.append(passengers[i].getSurname()).append(", ");
                sb.append(passengers[i].getAge()).append(" years old, ");
                sb.append("from ").append(passengers[i].getCity()).append(", ");
                sb.append("ticket number ").append(passengers[i].getTicketNumber()).append("\n");
            }
        }
        return sb.toString();
    }

}
