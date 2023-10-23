import java.util.Arrays;
import java.util.stream.Collectors;

public class JadenCase {

    public String toJadenCase(String phrase) {
        if (phrase == null || phrase.isBlank()) {
            return null;
        }

        return Arrays.stream(phrase.split("\\s+")).map(e -> e.substring(0, 1).toUpperCase() + e.substring(1)).collect(Collectors.joining(" "));
    }

}