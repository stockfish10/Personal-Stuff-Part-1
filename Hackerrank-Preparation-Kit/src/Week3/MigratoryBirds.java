package Week3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MigratoryBirds {
    public static void main(String[] args) {

    }
    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here

        Map<Integer,Integer> birds = new HashMap<>();

        for (Integer bird : arr) {
            if (birds.containsKey(bird)){
                birds.put(bird,birds.get(bird) + 1);
            } else {
                birds.putIfAbsent(bird, 1);
            }
        }

        List<Integer> values = birds.entrySet().stream()
                .filter(e-> e.getValue() == birds.values().stream().mapToInt(i -> i)
                        .max().getAsInt())
                .mapToInt(Map.Entry::getKey).boxed().collect(Collectors.toList());

        return values.stream().mapToInt(e->e).min().getAsInt();
    }
}
