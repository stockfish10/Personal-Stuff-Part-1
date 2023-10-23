
class DoubleLinear {

    //Does not pass all tests on codewars due to "Max Buffer Size Reached (1.5 MiB)"
    public static int dblLinear(int n) {
        int[] numbers = new int[n + 1];

        numbers[0] = 1;

        int x = 0;
        int y = 0;

        int counter = 1;

        for (int i = 0; i < n; i++) {

            int nextX = 2 * numbers[x] + 1;
            int nextY = 3 * numbers[y] + 1;

            if (nextX <= nextY) {
                numbers[counter] = nextX;
                x++;
                counter++;

                if (nextX == nextY) {
                    y++;
                }
            } else {
                numbers[counter] = nextY;
                y++;
                counter++;
            }
        }
        return numbers[n];
    }
}