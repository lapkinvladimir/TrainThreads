package FirstProject.MultiThreading;

import FirstProject.Execptions.RailroadHazard;
import FirstProject.RailwayCars.Locomotive;
import FirstProject.Graph.TrainStationGraph;
import java.util.List;

public class LocoMoving extends Thread {
    private TrainStationGraph stationGraph;
    private Locomotive locomotive;
    private List<String> route;
    private int currentIndex = 0;
    private boolean directionForward = true;
    private double totalDistance;
    private double distanceForward = 0;
    private final int LAST_STATION_WAIT_TIME = 30000;
    private double SPEED = 50;
    private boolean pause = false;

    public LocoMoving(TrainStationGraph stationGraph, Locomotive locomotive) {
        this.stationGraph = stationGraph;
        this.locomotive = locomotive;
        this.route = stationGraph.getDirections(locomotive.getBaseStation(), locomotive.getDestinationStation());
        totalDistance = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            String station1 = route.get(i);
            String station2 = route.get(i + 1);
            int distance = stationGraph.getDistanceBetweenStations(station1, station2);
            totalDistance += distance;
        }
        this.totalDistance = totalDistance;

    }


    public void run() {

        new Speed(locomotive).start();

        System.out.println("Locomotive #" + locomotive.getId() + " started from station " + getCurrentStation());


        while (true) {
                    if (isLastStation()) {
                        this.distanceForward = 0;
                        locomotive.setPercentage(0);
                        System.out.println(locomotive.getDestinationStation() + " is the last station for Locomotive #" + locomotive.getId() + "\n");
                        try {
                            Thread.sleep(LAST_STATION_WAIT_TIME);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        directionForward = !directionForward;
                    }
                    try {
                        int distance = stationGraph.getDistanceBetweenStations(getCurrentStation(), getNextStation());
                        this.distanceForward += distance;
                        locomotive.setPercentage(Math.floor(this.distanceForward / this.totalDistance * 100));
                        Thread.sleep((long) getTravelTime(getCurrentStation(), getNextStation()) * 900);
                        System.out.println("Locomotive #" + locomotive.getId() + " is on station " + getNextStation());
                        System.out.println("Locomotive #" + locomotive.getId() + " is going to the next station" + "\n");
                        Thread.sleep(2000);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (directionForward) {
                        currentIndex++;
                    } else {
                        currentIndex--;
                    }
                }
            }

    private String getCurrentStation() {
        return route.get(currentIndex);
    }

    private String getNextStation() {
        if (directionForward) {
            return route.get(currentIndex + 1);

        } else {
            return route.get(currentIndex - 1);

        }
    }

    private boolean isLastStation() {
        if (directionForward) {
            return currentIndex == route.size() - 1;
        } else {
            return currentIndex == 0;
        }
    }

    private double getTravelTime(String station1, String station2) {
        int distance = stationGraph.getDistanceBetweenStations(station1, station2);
        double timeInHours = distance / SPEED;

        return timeInHours;
    }

    static class Speed extends Thread {

        Locomotive locomotive;

        public Speed(Locomotive locomotive) {
            this.locomotive = locomotive;
        }

        public void run() {
            while (true) {
                try {
                    locomotive.changeSpeed();
                } catch (RailroadHazard e) {
                    System.out.println(e.getMessage());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

