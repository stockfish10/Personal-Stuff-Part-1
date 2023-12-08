package Day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        File fp = new File("src/Day4/Input.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        List<String> list = br.lines().toList();
        
        Map<String, Integer> cardsWithCount = new LinkedHashMap<>();

        for (String row : list) {
            String currentCardMain = row.split(":")[0];
            String allNumbers = row.split(":")[1];
            int cardNumber = Integer.parseInt(currentCardMain.split("\\s+")[1]);

            String currentCard = "Card " + cardNumber;

            if (!cardsWithCount.containsKey(currentCard.trim())){
                cardsWithCount.put(currentCard,1);
            } else {
                cardsWithCount.put(currentCard, cardsWithCount.get(currentCard) + 1);
            }
            
            String [] winningNumbers = allNumbers.trim().split("\\|")[0].trim().split("\\s+");
            String [] numbersToCheck = allNumbers.trim().split("\\|")[1].trim().split("\\s+");


            int counter = 0;
            
            for (int i = 0; i < cardsWithCount.get(currentCard); i++) {
                for (String winningNum : winningNumbers) {
                    boolean isContained = Arrays.asList(numbersToCheck).contains(winningNum);

                    if (isContained){
                        counter ++;
                    }
                }
                for (int k = 1; k <= counter; k++) {
                    String cardToUpdate = "Card " + (cardNumber + k);

                    if (cardsWithCount.containsKey(cardToUpdate)) {
                        cardsWithCount.put(cardToUpdate, cardsWithCount.get(cardToUpdate) + 1);
                    } else {
                        cardsWithCount.put(cardToUpdate, 1);
                    }
                }
                counter = 0;
            }
        }
        int sum = 0;

        for (Integer value : cardsWithCount.values()) {
            sum+=value;
        }

        System.out.println("The value is: " + sum);

//        for (Map.Entry<String, Integer> stringIntegerEntry : cardsWithCount.entrySet()) {
//            System.out.println(stringIntegerEntry.getKey() + "========" + stringIntegerEntry.getValue());
//        }
    }
}
