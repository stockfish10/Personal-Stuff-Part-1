public class DRoot {

    public static void main(String[] args) {
        System.out.println(digital_root(493193));
    }

    public static int digital_root(int n) {

        if (n == 0) {
            return 0;
        }

        int currentNum = n;
        int sum = 0;

        while (currentNum > 0) {
            int toAdd = currentNum % 10;
            sum+=toAdd;
            currentNum = currentNum/10;

            if (currentNum <= 0 && sum >= 10) {
                currentNum = sum;
                sum = 0;
            }
        }

        return sum;
    }
}