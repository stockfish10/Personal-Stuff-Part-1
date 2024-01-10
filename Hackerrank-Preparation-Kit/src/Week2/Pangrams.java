package Week2;

import java.util.HashMap;
import java.util.Map;

public class Pangrams {
    public static void main(String[] args) {
        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
    }

    public static String pangrams(String s) {

        Map<Character, Integer> characterMap = new HashMap<>();

        for (char c : s.toCharArray()) {

            if (c != ' ') {
                char current = Character.toLowerCase(c);

                characterMap.putIfAbsent(current, 1);
                if (characterMap.containsKey(current)) {
                    characterMap.put(current, characterMap.get(current) + 1);
                }
            }
        }
        if (characterMap.size() == 26) {
            return "pangram";
        }
        return "not pangram";
    }
}
