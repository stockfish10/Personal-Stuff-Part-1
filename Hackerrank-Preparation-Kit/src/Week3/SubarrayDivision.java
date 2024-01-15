package Week3;

import java.util.ArrayList;
import java.util.List;

public class SubarrayDivision {
    public static void main(String[] args) {
        System.out.println(birthday(List.of(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1),18,7));
    }
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here

        if (s.size() == 1 && m == 1 && s.get(0) == d) {
            return 1;
        }
        int numberOfWays = 0;

        for (int i = 0; i < s.size()-m+1; i++) {
            List<Integer> currentList = new ArrayList<>();
            currentList.add(s.get(i));
            int counter = 1;
            for (int j = i+1; j < s.size(); j++) {
                currentList.add(s.get(j));
                 if (currentList.size() > m){
                    currentList.remove(counter);
                } else if (currentList.size() == m){
                    if (currentList.stream().mapToInt(e->e).sum() == d) {
                        numberOfWays++;
                        currentList.add(j);
                    }
                }

            }
        }
        return numberOfWays;
    }
}
