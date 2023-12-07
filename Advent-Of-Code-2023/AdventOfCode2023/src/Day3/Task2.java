package Day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        File fp = new File("src/Day3/Input.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        List<char[]> matrixInput = new ArrayList<>();

        br.lines().forEach(line -> {
            matrixInput.add(line.toCharArray());
        });

        String pattern = "[*]";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher("");

        int sum = 0;

        for (int row = 0; row < matrixInput.size(); row++) {
            for (int col = 0; col < matrixInput.get(row).length; col++) {
                char current = matrixInput.get(row)[col];

                boolean isCurrentASymbol = checkIfCharacterIsSymbol(matcher,current);

                if (isCurrentASymbol) {
                    List<String> numericValues = checkForNumbersInEachDirection(matrixInput,row,col);

                    if (numericValues.size()==2){
                        sum = sum + Integer.parseInt(numericValues.get(0))*Integer.parseInt(numericValues.get(1));
                    }
                }
            }
        }
        System.out.println(sum);

    }

    private static List<String> checkForNumbersInEachDirection(List<char[]> matrixInput, int row, int col) {

        List<String> valuesToReturn = new ArrayList<>();

        String upperLeftDiagonal = getString(matrixInput, row-1, col-1);
        String upper = getString(matrixInput, row-1, col);
        String upperRightDiagonal = getString(matrixInput, row-1, col+1);
        String left = getString(matrixInput, row, col-1);
        String right = getString(matrixInput, row, col+1);
        String lowerLeftDiagonal = getString(matrixInput, row+1, col-1);
        String lower = getString(matrixInput, row+1, col);
        String lowerRightDiagonal = getString(matrixInput, row+1, col+1);

        if (upperLeftDiagonal != null) {
            valuesToReturn.add(upperLeftDiagonal);
        }
        if (upper != null) {
            valuesToReturn.add(upper);
        }
        if (upperRightDiagonal != null) {
            valuesToReturn.add(upperRightDiagonal);
        }
        if (left != null) {
            valuesToReturn.add(left);
        }
        if (right != null) {
            valuesToReturn.add(right);
        }
        if (lowerLeftDiagonal != null) {
            valuesToReturn.add(lowerLeftDiagonal);
        }
        if (lower != null) {
            valuesToReturn.add(lower);
        }
        if (lowerRightDiagonal != null) {
            valuesToReturn.add(lowerRightDiagonal);
        }

        return valuesToReturn;
    }

    private static String getString(List<char[]> matrixInput, int row, int col) {

        StringBuilder sb = new StringBuilder();

        if (row >= 0 && col >= 0 && row < matrixInput.size() && col < matrixInput.get(row).length) {
            char current = matrixInput.get(row)[col];
            boolean charCheck = checkIfCharacterIsNumeric(current);

            if (!charCheck) {
                return null;
            }

            sb.append(current);
            matrixInput.get(row)[col] = '.';
            int i = 1;

            while (col-i >= 0) {
                if (!checkIfCharacterIsNumeric(matrixInput.get(row)[col-i])) {
                    break;
                }
                sb.insert(0,matrixInput.get(row)[col-i]);
                matrixInput.get(row)[col-i] = '.';
                i++;
            }

            i = 1;

            while (col+i >= 0 && col+i < matrixInput.get(row).length) {
                if (!checkIfCharacterIsNumeric(matrixInput.get(row)[col+i])) {
                    break;
                }
                sb.append(matrixInput.get(row)[col+i]);
                matrixInput.get(row)[col+i] = '.';
                i++;
            }

        }
        return sb.toString();
    }

    private static boolean checkIfCharacterIsSymbol(Matcher matcher, char current) {
        matcher.reset(String.valueOf(current));
        return matcher.find();
    }

    private static boolean checkIfCharacterIsNumeric(char current) {
        try {
            double num = Double.parseDouble(String.valueOf(current));
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
}