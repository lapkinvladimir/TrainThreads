package FirstProject.Report;

import FirstProject.RailwayCars.Locomotive;

import java.util.HashMap;
import java.util.Scanner;


public class Report extends Thread {

    Scanner scanner = new Scanner(System.in);
    public HashMap<Integer, Locomotive> locomotiveHashMap = Locomotive.locomotiveHashMap;

    @Override
    public void run() {
        System.out.println("\n You can use this commands:" +
                "\n W (Locomotive Id) - to see information about the traveled distance" +
                "\n G (Locomotive Id) - to see general information about locomotives");
        while (true) {
            String input = scanner.nextLine();
            String[] words = input.split(" ");

            String firstWord = words[0];
            String secondWord = words[1];


            if ((firstWord.equals("g") || firstWord.equals("w"))) {
                if (firstWord.equals("g")) {
                    command1(Integer.parseInt(secondWord));
                }else {
                    command2(Integer.parseInt(secondWord));
                }
            }
        }
    }


    private void command1(int index) {
        if (!locomotiveHashMap.containsKey(index)) {
            System.out.println("Not correct index");
            return;
        }
        System.out.println(locomotiveHashMap.get(index));

    }

    private void command2(int index) {
        if (!locomotiveHashMap.containsKey(index)) {
            System.out.println("Not correct index");
            return;
        }
        System.out.println("Locomotive #" + index + " travelled " + locomotiveHashMap.get(index).getPercentage() + "% of all the way");
    }

}


