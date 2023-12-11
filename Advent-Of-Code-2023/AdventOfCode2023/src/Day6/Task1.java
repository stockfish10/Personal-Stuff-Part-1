package Day6;

import java.io.*;
import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) throws IOException {
        File fp = new File("src/Day6/Input.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        String timeMeasurements = br.readLine();
        String distanceMeasurements = br.readLine();

        int [] raceDurationValues = Arrays.stream(timeMeasurements.split(":")[1]
                .trim()
                .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int [] raceDistanceValues = Arrays.stream(distanceMeasurements.split(":")[1]
                        .trim()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();


        int sum = 1;

        for (int i = 0; i < raceDurationValues.length; i++) {

            int currentRaceDuration = raceDurationValues[i];
            int currentRaceDistance = raceDistanceValues[i];

            int currentWaysToWin = 0;

            for (int j = 1; j < currentRaceDuration; j++) {
                int currentDistanceTraveled = j * (currentRaceDuration-j);

                if (currentDistanceTraveled > currentRaceDistance) {
                    currentWaysToWin++;
                }
            }
            sum*=currentWaysToWin;
        }

        System.out.println(sum);
    }
}
