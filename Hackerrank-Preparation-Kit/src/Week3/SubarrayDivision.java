package Week3;

import java.util.ArrayList;
import java.util.List;

public class SubarrayDivision {
    public static void main(String[] args) {
        System.out.println(birthday(List.of(1,2,1,3,2),3,2));
    }
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here

        int numberOfWays = 0;

        for (int i = 0; i < s.size()-m; i++) {
            List<Integer> currentList = new ArrayList<>();
            currentList.add(s.get(i));
            int counter = i+1;
            for (int j = i+1; j < s.size(); j++) {
                currentList.add(j);
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
