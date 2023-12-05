package Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        File fp = new File("src/Day1/Input1.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        List<String> list = br.lines().toList();

        List<Integer> numbers = new ArrayList<>();

        for (String row : list) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < row.length(); i++) {
                sb.append(row.charAt(i));

                String currentSbWord = sb.toString().replaceAll("one","o1e").
                        replaceAll("two","t2o").
                        replaceAll("three","t3e").
                        replaceAll("four","f4r").
                        replaceAll("five","f5e").
                        replaceAll("six","s6x").
                        replaceAll("seven","s7n").
                        replaceAll("eight","e8t").
                        replaceAll("nine","n9e");

                sb.setLength(0);
                sb.append(currentSbWord);
            }

            String currentWord = sb.toString().
                    replaceAll("[^0-9]", "");

            if (currentWord.length() == 1) {
                numbers.add(Integer.parseInt(currentWord + currentWord));
            } else if (currentWord.length() == 2) {
                numbers.add(Integer.parseInt(currentWord));
            } else {
                String numberToAdd = currentWord.substring(0,1) + currentWord.substring(currentWord.length()-1);
                numbers.add(Integer.parseInt(numberToAdd));
            }
        }

//        for (Integer number : numbers) {
//            System.out.println(number);
//        }

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        System.out.println(sum);
    }
}
