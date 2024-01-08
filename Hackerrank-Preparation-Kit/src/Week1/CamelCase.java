package Week1;

import java.util.Scanner;

public class CamelCase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String input = scan.nextLine();

            String[] inputParts = input.split(";");
            StringBuilder sb = new StringBuilder();

            if ("S".equals(inputParts[0])) {

                char[] chars = inputParts[2].toCharArray();
                for (char aChar : chars) {
                    if (Character.isUpperCase(aChar)) {
                        sb.append(" ").append(Character.toLowerCase(aChar));
                    } else if (aChar != '(' && aChar != ')') {
                        sb.append(aChar);
                    }
                }

            } else {
                String [] words = inputParts[2].split(" ");

                for (int i = 0; i < words.length; i++) {
                    if (i == 0){
                        sb.append(words[i]);
                    } else {
                        sb.append(words[i].substring(0,1).toUpperCase()).append(words[i].substring(1));
                    }
                }
                if (inputParts[1].equals("M")){
                    sb.append("()");
                } else if (inputParts[1].equalsIgnoreCase("C")) {
                    sb.replace(0,1, sb.substring(0,1).toUpperCase());
                }
            }

            System.out.println(sb.toString().trim());
        }
    }
}
