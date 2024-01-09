package Week1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.sort;

public class Test {
    public static void main(String[] args) {
        System.out.println(findMedian(List.of(5,3,1,2,4)));
    }
    public static int findMedian(List<Integer> arr) {


        List<Integer> myArr = arr.stream().sorted().collect(Collectors.toList());

        return myArr.get(myArr.size()/2);

    }
}
