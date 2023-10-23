public class DRoot {

    public static void main(String[] args) {
        System.out.println(digital_root(575740));
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
        }

        int finalNum = 0;

        while (sum > 0) {
            int toAdd = sum % 10;
            finalNum+=toAdd;
            sum = sum/10;
        }

        return finalNum;
    }
}