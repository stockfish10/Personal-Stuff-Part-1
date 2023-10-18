import java.util.Arrays;

public class WeightSort {

    public static void main(String[] args) {
        System.out.println(orderWeight("59544965313"));
    }

    public static String orderWeight(String strng) {
        String[] input = strng.trim().split("\\s+");

        for (int i = 0; i < input.length-1; i++) {
            for (int j = 0; j < input.length-i-1; j++) {

                long firstNum = Long.parseLong(input[j]);
                long secondNum = Long.parseLong(input[j+1]);

                long firstNumSum = 0;
                long secondNumSum = 0;

                while (firstNum > 0) {
                    long toAdd = firstNum % 10;
                    firstNumSum+=toAdd;
                    firstNum = firstNum/10;
                }
                while (secondNum > 0) {
                    long toAdd = secondNum % 10;
                    secondNumSum+=toAdd;
                    secondNum = secondNum/10;
                }

                if (secondNumSum < firstNumSum) {
                    String temp = input[j];

                    input[j] = input[j+1];
                    input[j+1] = temp;
                } else if (secondNumSum == firstNumSum) {
                    int compare = input[j+1].compareTo(input[j]);

                    if (compare < 0) {
                        String temp = input[j];

                        input[j] = input[j+1];
                        input[j+1] = temp;
                    }
                }
            }
        }


        return String.join(" ", input);
    }
}

