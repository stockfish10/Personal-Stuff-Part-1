package Week2;

import java.util.List;

public class DiagonalDifferences {
    public static void main(String[] args) {

        List<List<Integer>> myArr = List.of(
                List.of(1, 2, 3, 4),
                List.of(5, 6, 7, 8),
                List.of(1, 2, 3, 4),
                List.of(5, 6, 7, 8)
        );

        System.out.println(diagonalDifference(myArr));
    }
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int leftDiagonal = 0;
        int rightDiagonal = 0;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (i == j) {
                    leftDiagonal += arr.get(i).get(j);
                }
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            for (int j = arr.get(i).size()-1; j >= 0; j--) {
                if ((i + j) == (arr.size()-1)) {
                    rightDiagonal += arr.get(i).get(j);
                }
            }
        }

        return Math.abs(leftDiagonal-rightDiagonal);
    }
}
