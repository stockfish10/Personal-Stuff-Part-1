package Week1;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        System.out.println(fibonacciModified(0,1,10));

    }
    public static int fibonacciModified(int t1, int t2, int n) {
        // Write your code here

        int first = t1;
        int second = t2;

        for (int i = 0; i <= n-2; i++) {
            int nextNum = 0;

            if (i % 2 == 0) {
                nextNum = first + (second*second);
                first= nextNum;
            } else {
                nextNum = second + (first*first);
                second = nextNum;
            }
        }

        return (n-2)%2==0 ? first : second;
    }
}
