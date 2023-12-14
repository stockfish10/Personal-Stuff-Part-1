package Day8;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) throws IOException {
        File fp = new File("src/Day8/Input.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        char [] directions = br.readLine().toCharArray();

        List<String> lines = br.lines().skip(1).toList();


        Map<String, Node> nodes = lines.stream().map(Node::new)
                .collect(Collectors.toMap(o->o.mainPart,o->o));

        Node currentNode = nodes.get("AAA");

        int steps = 0;

        while (!"ZZZ".equals(currentNode.mainPart)) {
            for (char direction : directions) {
                currentNode = nodes.get(direction == 'L' ? currentNode.L : currentNode.R);
                steps++;
                if ("ZZZ".equals(currentNode.mainPart)){
                    break;
                }
            }
        }
        System.out.println(steps);
    }
        static class Node {
            String mainPart;
            String L;
            String R;

            Node(String line) {
                mainPart = line.split(" = ")[0];
                String otherPart = line.split(" = ")[1];

                otherPart = otherPart.substring(1, otherPart.length() - 1).trim();

                L = otherPart.split(", ")[0];
                R = otherPart.split(", ")[1];
            }
        }
}
