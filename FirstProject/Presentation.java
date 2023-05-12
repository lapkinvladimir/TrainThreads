package FirstProject;

import FirstProject.CargoCars.CargoCar;
import FirstProject.CargoCars.GasCar;
import FirstProject.CargoCars.LiquidCar;
import FirstProject.CargoCars.RefrigeratedCar;
import FirstProject.Execptions.MaxPressureException;
import FirstProject.Execptions.MaxTemperatureException;
import FirstProject.HeavyCars.ExplosiveCar;
import FirstProject.HeavyCars.LiquidToxicCar;
import FirstProject.HeavyCars.ToxicCar;
import FirstProject.RailwayCars.BaggageCar;
import FirstProject.RailwayCars.PassengerCar;
import FirstProject.RailwayCars.PostalCar;

public class Presentation {
    public static void main(String[] args) throws MaxTemperatureException, MaxPressureException {

//------This method generates a random number that is added to the current temperature instead of setting it directly------\\
//------this allows for simulating some random factors that may affect the temperature change in real-time, making the method more realistic------\\
        CargoCar cargoCar = new CargoCar("Odessa", true, 0, 0, 0, "15-06-1975", "ok", 150, 200);
        cargoCar.setTemperature(cargoCar.getTemperature());

//------CheckPressure checks the pressure level, if it is higher than the maximum, then throws an exception------\\
        GasCar gasCar = new GasCar("Odessa", true, 0, 0, 0, "27-11-1965", "ok", 30, 200, 500, 10, 100);
        gasCar.setMaxPressure(100);
        gasCar.setCurrentPressure(150);
        gasCar.checkPressure();

//------CheckDanger checks if LiquidType contains nitroglycerin then danger becomes 1------\\
        LiquidCar liquidCar = new LiquidCar("Odessa", true, 0, 0, 0, "02-03-1984", "ok", 30, 200, "standard", 15, 100, 100);
        liquidCar.setLiquidType("nitroglycerin");
        liquidCar.checkDanger();

//------If there are fruits in the refrigerator car, then humidityControl will become true------\\
        RefrigeratedCar refrigeratedCar = new RefrigeratedCar("Odessa", true, 0, 0, 0, "10-10-2000", "ok", 30, 200, 50, 10, 500);
        refrigeratedCar.load();

//------If the car contains TNT then the danger level will become 5, and if it contains detonators, then the danger level will be 7------\\
        ExplosiveCar explosiveCar = new ExplosiveCar("Odessa", true, 0, 0, 0, "05-06-1967", "ok", 35, 500, 0);
        explosiveCar.load();

//------If the car contains mercury then the chemicalEquipment will become true------\\
        LiquidToxicCar liquidToxicCar = new LiquidToxicCar("Odessa", true, 0, 0, 0, "11-09-1985", "ok", "standard", 5, 0, 100);
        liquidToxicCar.load();

//------If the ToxicityLevel more than 25 then the protectiveGearRequired will become true------\\
        ToxicCar toxicCar = new ToxicCar("Odessa", true, 0, 0, 0, "22-03-1992", "ok", 70, 200, 0);
        toxicCar.setToxicityLevel(50);

//------Makes the loading of the car, and after it the car will contain one of the types of luggage in some quantity------\\
        BaggageCar baggageCar = new BaggageCar("Odessa", true, 0, 0, 0, "14-05-1957", "ok", 10, 200, 0);
        baggageCar.load();

//------Adds passengers(first name, last name, city, ticket number) to the car depending on numOfSeats------\\
        PassengerCar passengerCar = new PassengerCar("Odessa", true, 0, 0, 10, "30-07-1974", "ok");
        passengerCar.load();
        System.out.println(passengerCar.getPassengerList());

//------Adds letters to the car (sender, recipient, city, letter text) depending on mailSlots. SortMail sorts letters alphabetically------\\
        PostalCar postalCar = new PostalCar("Odessa", true, 0, 0, 0, "17-02-1989", "ok", 5, 200, new String[]{"1", "2", "3", "4", "5"});
        postalCar.load();
        postalCar.sortMail();
        System.out.println(postalCar.getPostalList());
    }
}
