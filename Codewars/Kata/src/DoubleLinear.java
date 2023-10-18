import java.util.ArrayList;
import java.util.List;



class DoubleLinear {

    //Does not pass all tests on codewars due to "Max Buffer Size Reached (1.5 MiB)"
    public static int dblLinear (int n) {
        List<Integer> numbers = new ArrayList<>(List.of(1));

        int x = 0;
        int y = 0;

        while (numbers.size() <= n ) {

            int nextX = 2 * numbers.get(x) + 1;
            int nextY = 3 * numbers.get(y) + 1;

            if (nextX <= nextY) {
                numbers.add(nextX);
                x++;

                if (nextX == nextY) {
                    y++;
                }
            } else {
                numbers.add(nextY);
                y++;
            }
        }
        System.out.println(numbers);
        return numbers.get(n);
    }
}