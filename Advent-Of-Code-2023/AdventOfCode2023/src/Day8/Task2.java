package Day8;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) throws IOException {
        File fp = new File("src/Day8/Input.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        char [] directions = br.readLine().toCharArray();

        List<String> lines = br.lines().skip(1).toList();


        Map<String, Node> nodes = lines.stream().map(Node::new)
                .collect(Collectors.toMap(o->o.mainPart,o->o));

        List<String> nodesToCheck = new ArrayList<>(nodes.keySet());

        nodesToCheck = nodesToCheck.stream().filter(e -> e.endsWith("A")).toList();

        int steps = 0;


        while (!checkAllEndPoints(nodesToCheck, nodesToCheck.size())) {
            for (char direction : directions) {
                for (int nodeIndex = 0; nodeIndex < nodesToCheck.size()-1; nodeIndex++) {
                    String newNode = nodes.get(direction == 'L' ? nodes.get(nodesToCheck.get(nodeIndex)).L : nodes.get(nodesToCheck.get(nodeIndex)).R).mainPart;


                }
                steps++;

                if (!checkAllEndPoints(nodesToCheck, nodesToCheck.size())){
                    break;
                }
            }
        }
        System.out.println(steps);
    }

    private static boolean checkAllEndPoints(List<String> endPoints, int len) {
        return endPoints.stream().filter(e -> e.endsWith("Z")).toList().size() == len;
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
