package Week3;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagSequence {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner kb = new Scanner(System.in);
        int test_cases = 1;
        for(int cs = 1; cs <= test_cases; cs++){
            int n = 7;
            int a[] = {1, 2, 3, 4, 5, 6, 7};

            findZigZagSequence(a, n);
        }
    }

    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = (n)/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
