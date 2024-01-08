package Week1;

import java.util.List;

public class BreakingRecord {
    public static void main(String[] args) {

    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        long minScore = Long.MAX_VALUE;
        long maxScore = Long.MIN_VALUE;

        int timesBeatMinScore = 0;
        int timesBeatMaxScore = 0;

        for (int i = 0; i < scores.size(); i++) {
            if (i == 0) {
                minScore = scores.get(i);
                maxScore = scores.get(i);
            }

            if (scores.get(i) > maxScore) {
                maxScore = scores.get(i);
                timesBeatMaxScore++;
            }
            if (scores.get(i)< minScore) {
                minScore = scores.get(i);
                timesBeatMinScore++;
            }
        }

        return List.of(timesBeatMaxScore,timesBeatMinScore);
    }
}
