package FirstProject.RailwayCars;

import FirstProject.CargoCars.CargoCar;
import FirstProject.CargoCars.GasCar;
import FirstProject.CargoCars.LiquidCar;
import FirstProject.CargoCars.RefrigeratedCar;
import FirstProject.Graph.Stations;
import FirstProject.HeavyCars.ExplosiveCar;
import FirstProject.HeavyCars.LiquidToxicCar;
import FirstProject.HeavyCars.ToxicCar;
import FirstProject.MultiThreading.LocoMoving;
import FirstProject.Report.Report;
import FirstProject.Report.Writing;
import FirstProject.Graph.TrainStationGraph;

import java.util.Random;


public class main {

    public static void main(String[] args) {

        Locomotive locomotive1 = new Locomotive(50, 10000, 25, "AAA_LOCOMOTIVE_111", "Lop Buri", "", "Kyiv",
                25, 200, "standard", 100);
        Locomotive locomotive2 = new Locomotive(15, 10000, 50, "BBB_LOCOMOTIVE_222", "Kowalewo Pomorskie Miasto", "", "Jurkowo Wegorzewskie",
                50, 200, "standard", 100);
        Locomotive locomotive3 = new Locomotive(100, 10000, 75, "CCC_LOCOMOTIVE_333", "Ostrowite k. Golubia", "", "Korzybie",
                75, 200, "standard", 100);
        Locomotive locomotive4 = new Locomotive(30, 10000, 100, "DDD_LOCOMOTIVE_444", "Golub-Dobrzyn", "", "Jonkowo",
                100, 200, "standard", 100);
        Locomotive locomotive5 = new Locomotive(15, 10000, 125, "EEE_LOCOMOTIVE_555", "Nieporet", "", "Kyiv",
                125, 200, "standard", 100);
        Locomotive locomotive6 = new Locomotive(80, 10000, 30, "FFF_LOCOMOTIVE_666", "Chelmoniec", "", "Lviv",
                30, 200, "standard", 100);
        Locomotive locomotive7 = new Locomotive(20, 10000, 55, "GGG_LOCOMOTIVE_777", "Gdynia Glowna", "", "Ternopil",
                55, 200, "standard", 100);
        Locomotive locomotive8 = new Locomotive(35, 10000, 80, "HHH_LOCOMOTIVE_888", "Lankiejmy", "", "Zakopane",
                80, 200, "standard", 100);
        Locomotive locomotive9 = new Locomotive(45, 10000, 105, "III_LOCOMOTIVE_999", "Tolniki Wielkie", "", "Uzhhorod",
                105, 200, "standard", 100);
        Locomotive locomotive10 = new Locomotive(25, 10000, 130, "JJJ_LOCOMOTIVE_101010", "Rajec Poduchowny", "", "Koszalin",
                130, 200, "standard", 100);
        Locomotive locomotive11 = new Locomotive(55, 10000, 155, "KKK_LOCOMOTIVE_111111", "Bardejov", "", "Mukachevo",
                155, 200, "standard", 100);
        Locomotive locomotive12 = new Locomotive(90, 10000, 35, "LLL_LOCOMOTIVE_121212", "Kosice Predmestie", "", "Kosice - Moldavska cesta",
                35, 200, "standard", 100);
        Locomotive locomotive13 = new Locomotive(40, 10000, 60, "MMM_LOCOMOTIVE_131313", "Bohumin", "", "Babiarova",
                60, 200, "standard", 100);
        Locomotive locomotive14 = new Locomotive(75, 10000, 85, "NNN_LOCOMOTIVE_141414", "Zilina", "", "Rzeszow",
                85, 200, "standard", 100);
        Locomotive locomotive15 = new Locomotive(70, 10000, 110, "OOO_LOCOMOTIVE_151515", "Piestany", "", "Zakopane Polana",
                110, 200, "standard", 100);
        Locomotive locomotive16 = new Locomotive(50, 10000, 135, "PPP_LOCOMOTIVE_161616", "Stryi", "", "Zakopane Budzowski N.",
                135, 200, "standard", 100);
        Locomotive locomotive17 = new Locomotive(15, 10000, 160, "QQQ_LOCOMOTIVE_171717", "Prague", "", "Humenne",
                160, 200, "standard", 100);
        Locomotive locomotive18 = new Locomotive(75, 10000, 65, "RRR_LOCOMOTIVE_777", "Lodz", "", "Poprad-Tatry",
                65, 200, "standard", 100);
        Locomotive locomotive19 = new Locomotive(20, 10000, 80, "SSS_LOCOMOTIVE_888", "Dnipro", "", "Kosice - Moldavska",
                80, 200, "standard", 100);
        Locomotive locomotive20 = new Locomotive(40, 10000, 90, "TTT_LOCOMOTIVE_999", "Skalite", "", "Kosice - KVP",
                90, 200, "standard", 100);
        Locomotive locomotive21 = new Locomotive(55, 10000, 70, "UUU_LOCOMOTIVE_1010", "Zakopane Polana Szymoszkowa", "", "Prerov",
                70, 200, "standard", 100);
        Locomotive locomotive22 = new Locomotive(45, 10000, 100, "VVV_LOCOMOTIVE_1111", "Wroclaw", "", "Zakopane Kościelisko",
                100, 200, "standard", 100);
        Locomotive locomotive23 = new Locomotive(70, 10000, 75, "WWW_LOCOMOTIVE_1212", "Kosice - Moldavska", "", "Kosice - Vyhliadka",
                75, 200, "standard", 100);
        Locomotive locomotive24 = new Locomotive(35, 10000, 85, "XXX_LOCOMOTIVE_1313", "Kosice - KVP", "", "Poprad zastavka",
                85, 200, "standard", 100);
        Locomotive locomotive25 = new Locomotive(50, 10000, 95, "YYY_LOCOMOTIVE_1414", "Trnava", "", "Stara Lubovna",
                95, 200, "standard", 100);


        Random random = new Random();

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive1.addRailwayCar(new HeavyCar("Odessa", true, 0, 0, 0, "01-01-1990", "ok"));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive2.addRailwayCar(new CargoCar("Odessa", true, 0, 0, 0, "15-06-1975", "ok", 30, 200));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive3.addRailwayCar(new GasCar("Odessa", true, 0, 0, 0, "27-11-1965", "ok", 30, 200, 500, 10, 100));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive4.addRailwayCar(new LiquidCar("Odessa", true, 0, 0, 0, "02-03-1984", "ok", 30, 200, "standard", 15, 100, 100));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive5.addRailwayCar(new RefrigeratedCar("Odessa", true, 0, 0, 0, "10-10-2000", "ok", 30, 200, 50, 10, 500));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive6.addRailwayCar(new ExplosiveCar("Odessa", true, 0, 0, 0, "05-06-1967", "ok", 35, 500, 0));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive7.addRailwayCar(new LiquidToxicCar("Odessa", true, 0, 0, 0, "11-09-1985", "ok", "standard", 5, 0, 100));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive8.addRailwayCar(new ToxicCar("Odessa", true, 0, 0, 0, "22-03-1992", "ok", 70, 200, 0));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive9.addRailwayCar(new BaggageCar("Odessa", true, 0, 0, 0, "14-05-1957", "ok", 10, 200, 0));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive10.addRailwayCar(new PassengerCar("Odessa", true, 0, 0, 0, "30-07-1974", "ok"));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive11.addRailwayCar(new PostalCar("Odessa", true, 0, 0, 0, "17-02-1989", "ok", 5, 200, new String[]{"1", "2", "3", "4", "5"}));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive12.addRailwayCar(new RestaurantCar("Odessa", true, 0, 0, 0, "23-12-1995", "ok", 200, 40, 0));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive13.addRailwayCar(new HeavyCar("Odessa", true, 0, 0, 0, "08-04-1963", "ok"));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive14.addRailwayCar(new CargoCar("Odessa", true, 0, 0, 0, "27-10-1978", "ok", 30, 200));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive15.addRailwayCar(new ExplosiveCar("Odessa", true, 0, 0, 0, "02-09-2000", "ok", 20, 200, 0));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive16.addRailwayCar(new ToxicCar("Odessa", true, 0, 0, 0, "08-04-1985", "ok", 25, 200, 0));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive17.addRailwayCar(new GasCar("Odessa", true, 0, 0, 0, "12-05-1992", "ok", 30, 200, 100, 60, 0));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive18.addRailwayCar(new RefrigeratedCar("Odessa", true, 0, 0, 0, "23-07-1978", "ok", 30, 200, 35, 0, 500));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive19.addRailwayCar(new BaggageCar("Odessa", true, 0, 0, 0, "19-09-1955", "ok", 24, 200, 0));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive20.addRailwayCar(new PostalCar("Odessa", true, 0, 0, 0, "31-12-2001", "ok", 3, 200, new String[]{"1", "2", "3"}));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive21.addRailwayCar(new RestaurantCar("Odessa", true, 0, 0, 0, "28-02-1987", "ok", 100, 0, 75));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive21.addRailwayCar(new LiquidCar("Odessa", true, 0, 0, 0, "15-08-1969", "ok", 30, 200, "standard", 35, 0, 500));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive22.addRailwayCar(new LiquidToxicCar("Odessa", true, 0, 0, 0, "02-06-1976", "ok", "standard", 0, 25, 100));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive23.addRailwayCar(new GasCar("Odessa", true, 0, 0, 0, "25-11-1998", "ok", 30, 200, 100, 85, 0));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive24.addRailwayCar(new RefrigeratedCar("Odessa", true, 0, 0, 0, "10-10-2005", "ok", 30, 200, 75, 0, 500));
        }

        for (int i = 0; i < random.nextInt(6) + 5; i++) {
            locomotive25.addRailwayCar(new LiquidToxicCar("Odessa", true, 0, 0, 0, "24-07-1973", "ok", "standard", 45, 0, 200));
        }


        TrainStationGraph trainStationGraph = new TrainStationGraph();

        Stations stations = new Stations();

        stations.addStations(trainStationGraph);

        stations.addLines(trainStationGraph);

        LocoMoving[] moves = new LocoMoving[25];
        Locomotive[] locomotives = new Locomotive[]{locomotive1, locomotive2, locomotive3, locomotive4, locomotive5, locomotive6, locomotive7, locomotive8, locomotive9, locomotive10, locomotive11, locomotive12, locomotive13, locomotive14, locomotive15, locomotive16, locomotive17, locomotive18, locomotive19, locomotive20, locomotive21, locomotive22, locomotive23, locomotive24, locomotive25};

        for (int i = 0; i < moves.length; i++) {
            moves[i] = new LocoMoving(trainStationGraph, locomotives[i]);
        }

        for (LocoMoving move : moves) {
            move.start();
        }

        Writing writing = new Writing(trainStationGraph);
        writing.start();

        Report report = new Report();
        report.start();


    }


}


