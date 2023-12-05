package Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        File fp = new File("src/Day1/Input1.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        List<String> list = br.lines().toList();

        List<Integer> numbers = new ArrayList<>();

        for (String row : list) {
            String numberOnly= row.replaceAll("[^0-9]", "");

            if (numberOnly.length() == 1) {
                numbers.add(Integer.parseInt(numberOnly + numberOnly));
            } else if (numberOnly.length() == 2) {
                numbers.add(Integer.parseInt(numberOnly));
            } else {
                String current = numberOnly.substring(0,1) + numberOnly.substring(numberOnly.length()-1);
                numbers.add(Integer.parseInt(current));
            }
        }


        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        System.out.println(sum);
    }
}
