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

            String[] subsetOfCubes = rowParts[1].split("; ");

            boolean gamePossible = true;

            gamePossible = isGamePossible(subsetOfCubes, gamePossible);


            if (gamePossible) {
                possibleIds.add(gameId);
            }

        }
       System.out.println(possibleIds.stream().mapToInt(e -> e).sum());
    }

    private static boolean isGamePossible(String[] subsetOfCubes, boolean gamePossible) {
        for (String subsetOfCube : subsetOfCubes) {
            String [] partsOfHand = subsetOfCube.trim().split(", ");

            gamePossible = checkHand(gamePossible, partsOfHand);
        }
        return gamePossible;
    }

    private static boolean checkHand(boolean gamePossible, String[] partsOfHand) {
        for (String hand : partsOfHand) {
            int numberOfCubesForCurrentHand = Integer.parseInt(hand.split("\\s+")[0].trim());
            String colorOfCubes = hand.split("\\s+")[1].trim();

            switch (colorOfCubes) {
                case "red":
                    if (numberOfCubesForCurrentHand > 12) {
                        gamePossible = false;
                    }
                    break;
                case "green":
                    if (numberOfCubesForCurrentHand > 13) {
                        gamePossible = false;
                    }
                    break;
                case "blue":
                    if (numberOfCubesForCurrentHand > 14) {
                        gamePossible = false;
                    }
                    break;
            }
        }
        return gamePossible;
    }
}
