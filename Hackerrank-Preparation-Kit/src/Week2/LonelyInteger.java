package Week2;

import java.util.*;

public class LonelyInteger {
    public static void main(String[] args) {
        System.out.println(lonelyinteger(List.of(1,2,3,4,3,2,1)));
    }
    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        a.forEach(e-> {
            if (frequencyMap.containsKey(e)){
                frequencyMap.put(e, frequencyMap.get(e) + 1);
            } else {
                frequencyMap.put(e,1);
            }
        });

        int numToReturn = 0;

        for (Map.Entry<Integer, Integer> integerIntegerEntry : frequencyMap.entrySet()) {
            if (integerIntegerEntry.getValue() == 1){
                numToReturn = integerIntegerEntry.getKey();
            }
        }
        return numToReturn;
    }
}
