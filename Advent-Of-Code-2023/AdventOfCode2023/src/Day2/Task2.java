package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        File fp = new File("src/Day2/Input.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        List<String> list = br.lines().toList();

        int totalSum = 0;

        for (String row : list) {
            String[] rowParts = row.split(": ");

            String[] subsetOfCubes = rowParts[1].split("; ");

            int redMin = 0;
            int greenMin = 0;
            int blueMin = 0;

            for (String subsetOfCube : subsetOfCubes) {
                String [] partsOfHand = subsetOfCube.trim().split(", ");

                for (String hand : partsOfHand) {
                    int numberOfCubesForCurrentHand = Integer.parseInt(hand.split("\\s+")[0].trim());
                    String colorOfCubes = hand.split("\\s+")[1].trim();

                    switch (colorOfCubes) {
                        case "red":
                            if (numberOfCubesForCurrentHand > redMin) {
                                redMin = numberOfCubesForCurrentHand;
                            }
                            break;
                        case "green":
                            if (numberOfCubesForCurrentHand > greenMin) {
                                greenMin = numberOfCubesForCurrentHand;
                            }
                            break;
                        case "blue":
                            if (numberOfCubesForCurrentHand > blueMin) {
                                blueMin = numberOfCubesForCurrentHand;
                            }
                            break;
                    }
                }
            }

            totalSum = totalSum + (redMin*blueMin*greenMin);
        }

        System.out.println(totalSum);

    }
}
