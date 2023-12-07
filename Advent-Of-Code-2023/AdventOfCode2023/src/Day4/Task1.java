package Day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        File fp = new File("src/Day4/Input.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        List<String> list = br.lines().toList();

        int totalPoints = 0;

        for (String row : list) {
            String allNumbers = row.split(":")[1];

            String [] winningNumbers = allNumbers.trim().split("\\|")[0].trim().split("\\s+");
            String [] numbersToCheck = allNumbers.trim().split("\\|")[1].trim().split("\\s+");

            int counter = 0;

            for (String winningNum : winningNumbers) {
                boolean isContained = Arrays.asList(numbersToCheck).contains(winningNum);

                if (isContained){
                    counter ++;
                }
            }

            totalPoints = totalPoints + addPoints(counter);
        }

        System.out.println(totalPoints);
    }

    private static int addPoints(int counter) {

        if (counter == 0){
            return 0;
        }

        int toReturn = 1;

        for (int i = 1; i < counter; i++) {
            toReturn*=2;
        }
        return toReturn;
    }
}
