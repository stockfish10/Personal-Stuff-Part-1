public class Isogram {
    public static void main(String[] args) {
        System.out.println(isIsogram("thumbscrewjapingly"));
    }

    public static boolean  isIsogram(String str) {

        if (str == null || str.isEmpty()) {
            return true;
        }

        boolean toReturn = true;

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length() ; j++) {
                if ( i != j ) {
                    if (str.charAt(i) == str.charAt(j)) {
                        toReturn = false;
                        break;
                    }
                }
            }
            if (!toReturn) {
                break;
            }
        }
        return toReturn;
    }
}