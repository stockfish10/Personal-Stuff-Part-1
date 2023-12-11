package Day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws IOException {
        File fp = new File("src/Day6/Input.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        String timeMeasurements = br.readLine();
        String distanceMeasurements = br.readLine();

        StringBuilder sb = new StringBuilder();

        List<StringBuilder> timeMeasurementsList = Arrays.stream(timeMeasurements.split(":")[1]
                        .trim()
                        .split("\\s+"))
                .map(sb::append).toList();

        long raceDuration = Long.parseLong(sb.toString().trim());

        sb.setLength(0);

        List<StringBuilder> distanceMEasurementsList = Arrays.stream(distanceMeasurements.split(":")[1]
                        .trim()
                        .split("\\s+"))
                .map(sb::append).toList();


        long distance = Long.parseLong(sb.toString().trim());

        long sum = 1;


        int currentWaysToWin = 0;

        for (int j = 1; j < raceDuration; j++) {
            long currentDistanceTraveled = j * (raceDuration - j);

            if (currentDistanceTraveled > distance) {
                currentWaysToWin++;
            }
        }
        sum *= currentWaysToWin;

        System.out.println(sum);

    }
}
