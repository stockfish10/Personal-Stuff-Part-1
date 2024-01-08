package Week1;

import java.util.ArrayList;
import java.util.List;

public class PlusMinus {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,1,0,-1,-1);
        plusMinus(nums);
    }

    public static void plusMinus(List<Integer> arr) {
        double positive = 0;
        double negative = 0;
        double zeros = 0;

        for (Integer integer : arr) {
            if (integer == 0){
                zeros++;
            } else if (integer > 0) {
                positive++;
            } else {
                negative++;
            }
        }

        positive = positive/arr.size();
        negative = negative/arr.size();
        zeros = zeros/arr.size();

        System.out.printf("%.6f\n",positive);
        System.out.printf("%.6f\n",negative);
        System.out.printf("%.6f",zeros);
    }

}
