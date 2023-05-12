package FirstProject.Report;

import FirstProject.RailwayCars.Locomotive;
import FirstProject.Graph.TrainStationGraph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;

public class Writing extends Thread{

    TrainStationGraph graph;

    public Writing(TrainStationGraph graph) {
        this.graph = graph;
    }

    private static String file = "src/AppState.txt";
    private static HashMap<Integer,Locomotive> map = Locomotive.locomotiveHashMap;
    public  void  run() {

        while (true) {
            Comparator<Locomotive> locomotiveComparator = new Comparator<Locomotive>() {
                public int compare(Locomotive p1, Locomotive p2) {
                    try {
                        return -1 * graph.destStartEnd(graph.getDirections(p1.getBaseStation(), p1.getDestinationStation())) + graph.destStartEnd(graph.getDirections(p2.getBaseStation(), p2.getDestinationStation()));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            map.forEach((key, value) -> {
                value.sortList();
            });


            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                map.values().stream().sorted(locomotiveComparator).map(value -> String.format("%s", value)).forEach(value -> {
                  try {
                       writer.write(value);
                       writer.newLine();
                      } catch (IOException e) {
                        e.printStackTrace();
                      }
                      });
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                System.out.println("Written to file \n");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

