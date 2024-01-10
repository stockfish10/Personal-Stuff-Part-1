package Week2;

public class CountingValleys {
    public static void main(String[] args) {
        System.out.println(countingValleys(8,"DDUUDDUDUUUD"));
    }
    public static int countingValleys(int steps, String path) {
        // Write your code here
        int seaLevel = 0;
        int valleyCounter = 0;
        boolean enteredValley = false;

        for (char c : path.toCharArray()) {
            if (seaLevel == 0 && c == 'D'){
                enteredValley = true;
            }
            if (seaLevel == 0 && c == 'U'){
                enteredValley = false;
            }
            if (c == 'D') {
                seaLevel--;
            } else {
                seaLevel++;
            }

            if (enteredValley && seaLevel == 0) {
                valleyCounter++;
            }
        }
        return valleyCounter;
    }
}
