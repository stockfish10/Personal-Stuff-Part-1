package Week3;

public class DrawingBook {
    public static void main(String[] args) {
        System.out.println(pageCount(6,5));
    }
    public static int pageCount(int n, int p) {
        // Write your code here
        if ((n/2 < p) && (n-p) == 1) {
            return n%2 == 0 ? 1 : 0;
        }
        return n/2 >= p ? p/2 : (n-p)/2;
    }
}
