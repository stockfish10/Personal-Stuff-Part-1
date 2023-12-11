package Day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        File fp = new File("src/Day7/Input.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        List<String> list = br.lines().toList();

        String[] cardList = list.toArray(String[]::new);

        Map<Character,Integer> cardStrength = new HashMap<>() {{
            put('2',2);
            put('3',3);
            put('4',4);
            put('5',5);
            put('6',6);
            put('7',7);
            put('8',8);
            put('9',9);
            put('T',10);
            put('J',11);
            put('Q',12);
            put('K',13);
            put('A',14);
        }};

        quickSort(cardList, 0, cardList.length - 1,cardStrength);

        long sum = 0;
        int counter = 1;

        for (String cardRow : cardList) {
            long currentBet = Long.parseLong(cardRow.split("\\s+")[1]);

            sum += currentBet*counter;

//            System.out.println(cardRow + "===" + counter);

            counter++;
        }

        System.out.println(sum);

    }

    private static boolean isCardCombinationLowerThanPivot(String currentHand, String pivot, Map<Character, Integer> cardStrength) {
        String cardsFromHand = currentHand.split("\\s+")[0];
        String cardsFromPivot = pivot.split("\\s+")[0];

        int handValue = checkForHandValue(cardsFromHand);
        int pivotValue = checkForHandValue(cardsFromPivot);

        if ((handValue == pivotValue)) {
            for (int i = 0; i < 5; i++) {
                if (handValue == 0 && pivotValue == 0) {
                    handValue = checkForHighCard(cardsFromHand,cardStrength);
                    pivotValue = checkForHighCard(cardsFromPivot, cardStrength);
                    break;
                }
                if (cardStrength.get(cardsFromHand.charAt(i)) < cardStrength.get(cardsFromPivot.charAt(i))) {
                    handValue = 1;
                    pivotValue = 2;
                    break;
                } else if (cardStrength.get(cardsFromHand.charAt(i)) > cardStrength.get(cardsFromPivot.charAt(i))) {
                    handValue = 2;
                    pivotValue = 1;
                    break;
                }
            }
        }
        return handValue < pivotValue;
    }

    private static int checkForHighCard(String cards, Map<Character, Integer> cardStrength) {

        int highestCard = 0;

        for (char card : cards.toCharArray()) {
            if (cardStrength.get(card) > highestCard) {
                highestCard = cardStrength.get(card);
            }
        }
        return highestCard;
    }

    private static int checkForHandValue(String cards) {
        Map<Character, Integer> cardsWithCount = new HashMap<>();

        for (char c : cards.toCharArray()) {
            cardsWithCount.put(c,cardsWithCount.getOrDefault(c,1)+1);
        }

        int pair = 0;
        int threeOfAKind = 0;
        int fourOfAKind = 0;
        int fiveOfAKind = 0;

        for (Integer value : cardsWithCount.values()) {
            if (value == 2) {
                pair++;
            } else if (value == 3) {
                threeOfAKind = value;
            } else if (value == 4) {
                fourOfAKind = 5;
                break;
            } else if (value == 5) {
                fiveOfAKind = 6;
                break;
            }
        }

        if (fiveOfAKind > 0) {
            return fiveOfAKind;
        } else if (fourOfAKind > 0){
            return fourOfAKind;
        } else if (pair == 1 && threeOfAKind > 0) {
            return 4;
        } else if (threeOfAKind > 0) {
            return threeOfAKind;
        }

        return pair;
    }

    static void quickSort(String[] arr, int low, int high, Map<Character, Integer> cardStrength) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high, cardStrength);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1, cardStrength);
            quickSort(arr, pi + 1, high, cardStrength);
        }
    }

    static int partition(String[] arr, int low, int high, Map<Character, Integer> cardStrength) {
        // Choosing the pivot
        String pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (isCardCombinationLowerThanPivot(arr[j], pivot, cardStrength)) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
