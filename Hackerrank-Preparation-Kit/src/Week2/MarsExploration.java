package Week2;

public class MarsExploration {
    public static void main(String[] args) {
        System.out.println(marsExploration("SOSSPSSQSSOR"));
    }
    public static int marsExploration(String s) {
        // Write your code here

        char [] sos = {'S','O','S'};

        int currentNum = 0;
        int differentLetters = 0;

        for (char c : s.toCharArray()) {
            if (sos[currentNum] != c){
                differentLetters++;
            }
            currentNum++;

            if (currentNum > 2){
                currentNum = 0;
            }
        }

        return differentLetters;
    }
}
