package Day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task1Obj {
    public static void main(String[] args) throws FileNotFoundException {
        File fp = new File("src/Day7/Input.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        List<String> list = br.lines().toList();

        List<Hand> hands = new ArrayList<>(list.stream().map(s -> new Hand(s, true)).toList());

        Collections.sort(hands);

        long sum = 0;

        for (int i = 0; i < hands.size(); i++) {
            sum+=(i+1) * hands.get(i).bid;
        }
        System.out.println(sum);
    }

    static class Hand implements Comparable<Hand> {
        int [] hand;
        long bid;
        int type;
        int [] byValue = new int [15];
        int jokerCards = 0;

        Hand(String s, boolean jokers) {
            bid = Integer.parseInt(s.split("\\s+")[1]);
            hand = s.split("\\s+")[0].chars().map(c -> {
                return switch (c) {
                    case 'A' -> 14;
                    case 'K' -> 13;
                    case 'Q' -> 12;
                    case 'J' -> jokers ? 1 : 11;
                    case 'T' -> 10;
                    default -> c - '0';
                };
            }).toArray();

            for (int card : hand) {
                if (card == 1) {
                    jokerCards++;
                } else {
                    byValue[card]++;
                }
            }
        }

        @Override
        public int compareTo(Hand o) {
            int [] groups = Arrays.stream(byValue).sorted().toArray();
            int [] otherGroups = Arrays.stream(o.byValue).sorted().toArray();
            int biggestGroup = groups[groups.length-1] + jokerCards;
            int otherBiggestGroup = otherGroups[otherGroups.length-1] + o.jokerCards;
            int delta = biggestGroup - otherBiggestGroup;

            if (delta != 0) {
                return delta;
            }
            if (biggestGroup == 3 || biggestGroup == 2) {
                boolean fullhouse = groups[groups.length-2] == 2;
                boolean otherFullHouse = otherGroups[otherGroups.length-2] == 2;

                if (fullhouse && !otherFullHouse) {
                    return 1;
                }
                if (!fullhouse && otherFullHouse) {
                    return -1;
                }
            }

            for (int i = 0; i < 5; i++) {
                delta = hand[i] - o.hand[i];
                if (delta != 0){
                    return delta;
                }
            }
            return 0;
        }
    }
}
