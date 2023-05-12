package FirstProject.Graph;

import java.util.*;

public class TrainStationGraph {
    private Map<String, TrainStation> stations = new HashMap<>();

    public List<String> getDirections (String start, String end) {
        TrainStation startStation = stations.get(start);
        TrainStation endStation = stations.get(end);
        Set<TrainStation> visited = new HashSet<>();
        Stack<TrainStation> stack = new Stack<>();
        Map<TrainStation, TrainStation> previousStations = new HashMap<>();
        stack.push(startStation);

        while (!stack.isEmpty()) {
            TrainStation currentStation = stack.pop();
            visited.add(currentStation);

            if (currentStation == endStation) {
                List<String> path = new ArrayList<>();
                TrainStation station = endStation;
                while (station != null) {
                    path.add(0, station.getName());
                    station = previousStations.get(station);
                }
                if (!path.get(0).equals(start)) {
                    return null;
                }
                return path;
            }

            for (Connection connection : currentStation.getConnections()) {
                TrainStation neighborStation = connection.getStation();
                if (!visited.contains(neighborStation)) {
                    previousStations.put(neighborStation, currentStation);
                    stack.push(neighborStation);
                }
            }
        }

        return null;
    }

    public void addStation(String name) {
        stations.put(name, new TrainStation(name));
    }

        public void addLine(String source, String destination, int distance) {
        TrainStation s = stations.get(source);
        TrainStation d = stations.get(destination);
        s.addConnection(d, distance);
        d.addConnection(s, distance);
    }


    public int getDistanceBetweenStations(String station1Name, String station2Name) {
        TrainStation station1 = stations.get(station1Name);
        TrainStation station2 = stations.get(station2Name);

        if (station1 != null) {
            for (Connection connection : station1.getConnections()) {
                if (connection.getStation().equals(station2)) {
                    return connection.getDistance();
                }
            }
        }
        return -10;
    }



    public int destStartEnd(List<String> list){
        int ans = 0;
        for (int i = 0; i < list.size()-1; i++) {
            ans+= this.getDistanceBetweenStations(list.get(i) , list.get(i+1));
        }
        return ans;
    }

    public boolean hasStation(String name) {
        return stations.containsKey(name);
    }

    public TrainStation getStation(String name) {
        return stations.get(name);
    }

    public static class TrainStation {
        private String name;
        private List<Connection> connections = new ArrayList<>();

        public TrainStation(String name) {
            this.name = name;
        }

        public void addConnection(TrainStation station, int distance) {
            connections.add(new Connection(station, distance));
        }

        public List<Connection> getConnections() {
            return connections;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TrainStation)) {
                return false;
            }
            TrainStation other = (TrainStation) obj;
            return Objects.equals(name, other.name);
        }
    }

    public static class Connection {
        private TrainStation station;
        private int distance;

        public Connection(TrainStation station, int distance) {
            this.station = station;
            this.distance = distance;
        }

        public TrainStation getStation() {
            return station;
        }

        public int getDistance() {
            return distance;
        }
    }
}