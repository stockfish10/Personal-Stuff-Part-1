package Week3;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PermuteTwoArrays {
    public static void main(String[] args) {

    }

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here
        Collections.sort(A);
        B.sort(Collections.reverseOrder());

        boolean isValid = true;

        for (int i = 0; i < A.size(); i++) {
            if ((A.get(i) + B.get(i)) < k) {
                isValid = false;
                break;
            }
        }

        return isValid ? "YES" : "NO";
    }

}
