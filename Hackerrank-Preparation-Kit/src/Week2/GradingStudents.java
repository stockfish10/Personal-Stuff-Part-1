package Week2;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GradingStudents {
    public static void main(String[] args) {
        List<Integer> nums = gradingStudents(List.of(23,
                80,
                96,
                18,
                73,
                78,
                60,
                60,
                15,
                45,
                15,
                10,
                5,
                46,
                87,
                33,
                60,
                14,
                71,
                65));

        for (Integer num : nums) {
            System.out.println(num);
        }

    }
    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        //roundUp = (value + 9) / 10 * 10;
        //roundHalfUp = (value + 5) / 10 * 10;

        List<Integer> nums = new ArrayList<>();

        for (Integer grade : grades) {
            if (grade < 38){
                nums.add(grade);
            } else if (grade % 5 >= 3){
                nums.add(grade + (5 - (grade % 5)));
            } else {
                nums.add(grade);
            }
        }

        return nums;
    }
}
