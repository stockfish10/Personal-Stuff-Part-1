package Day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        File fp = new File("src/Day8/Input.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        List<String> list = br.lines().toList();
    }
}
