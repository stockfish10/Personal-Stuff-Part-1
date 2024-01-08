package Week1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MinMaxSum {
    public static void main(String[] args) {

        List<Integer> nums = List.of(1,3,5,7,9);

        miniMaxSum(nums);

    }

    public static void miniMaxSum(List<Integer> arr) {
        long minSum = Long.MAX_VALUE;
        long maxSum = Long.MIN_VALUE;


        for (int i = 0; i <= 4; i++) {
            long sum = 0;

            for (int j = 0; j < arr.size(); j++) {
                if (i != j) {
                    sum+=arr.get(j);
                }
            }

            if (sum < minSum) {
                minSum = sum;
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        System.out.println(minSum + " " + maxSum);
    }
}
