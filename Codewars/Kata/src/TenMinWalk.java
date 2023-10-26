public class TenMinWalk {

    public static void main(String[] args) {
        System.out.println(isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
    }

    public static boolean isValid(char[] walk) {
        // Insert brilliant code here

        if (walk.length != 10) {
            return false;
        }

        int a = 0;
        int b = 0;

        for (char c : walk) {
            switch (c) {
                case 'n' -> a += 1;
                case 's' -> a -= 1;
                case 'e' -> b += 1;
                case 'w' -> b -= 1;
            }
        }


        return a == 0 && b == 0;
    }
}