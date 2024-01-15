package Week3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesByMatch {
    public static void main(String[] args) {
        System.out.println(sockMerchant(7, List.of(1,2,1,2,1,3,2)));
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here

        Map<Integer, Integer> socks = new HashMap<>();

        int matchingSocks = 0;

        for (Integer sock : ar) {

            if (socks.containsKey(sock)){
                socks.put(sock, socks.get(sock) + 1);
            } else {
                socks.putIfAbsent(sock, 1);
            }
        }

        for (Integer value : socks.values()) {
            if (value % 2 == 0) {
                matchingSocks = matchingSocks + (value / 2);
            } else if (((value - 1) / 2) != 0) {
                matchingSocks = matchingSocks + ((value - 1) / 2);
            }
        }

        return matchingSocks;
    }
}
