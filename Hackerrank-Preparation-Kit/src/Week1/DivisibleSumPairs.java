package Week1;

import java.util.List;

public class DivisibleSumPairs {
    public static void main(String[] args) {

        System.out.println(divisibleSumPairs(6,5,List.of(1,2,3,4,5,6)));
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here

        int pairs = 0;

        for (int i = 0; i < ar.size()-1; i++) {
            for (int j = i; j < ar.size(); j++) {
                int first = ar.get(i);
                int second = ar.get(j);

                if ((first + second) % k == 0 && i<j) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}
