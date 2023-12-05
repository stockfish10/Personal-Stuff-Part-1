package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        File fp = new File("src/Day2/Input.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        List<String> list = br.lines().toList();

        List<Integer> possibleIds = new ArrayList<>();

        for (String row : list) {

            String[] rowParts = row.split(": ");

            int gameId = Integer.parseInt(rowParts[0].split("\\s+")[1]);

            String[] subsetOfCubes = rowParts[1].split(";");

            boolean validGameId = isValidGameId(subsetOfCubes);

            if (validGameId) {
                possibleIds.add(gameId);
            }

        }
        System.out.println(possibleIds.stream().mapToInt(e -> e).sum());
    }

    private static boolean isValidGameId(String[] subsetOfCubes) {
        for (String subsetOfCube : subsetOfCubes) {
            String[] cubeHand = subsetOfCube.trim().split(", ");

            for (String hand : cubeHand) {
                int numberOfCubes = Integer.parseInt(hand.split("\\s+")[0]);
                String color = hand.split("\\s+")[1];

                switch (color) {
                    case "red":
                        if (numberOfCubes > 12) {
                            return false;
                        }
                    case "blue":
                        if (numberOfCubes > 14) {
                            return false;
                        }
                    case "green":
                        if (numberOfCubes > 13) {
                            return false;
                        }
                }
            }
        }
        return true;
    }
}
