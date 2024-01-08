package Week1;

import java.util.ArrayList;
import java.util.List;

public class SparseArray {
    public static void main(String[] args) {

    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        List<Integer> output = new ArrayList<>();

        for (String query : queries) {
            int currentCount = 0;
            for (String string : strings) {
                if (query.equals(string)){
                    currentCount++;
                }
            }
            output.add(currentCount);
        }
        return output;
    }
}
