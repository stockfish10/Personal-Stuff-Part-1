package Week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxPerimeterTriangle {
    public static void main(String[] args) {

    }

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        // Write your code here

        //Sort
        Collections.sort(sticks,Collections.reverseOrder());
        long topVal = 0L;
        int mxA = 0;
        int mxB = 0;
        int mxC = 0;
        boolean hasNonD = false;
        for(int i = 0; i < sticks.size()-2; i++){
            int A = sticks.get(i);
            int B = sticks.get(i+1);
            int C = sticks.get(i+2);
            if(A < (B + C)){
                long val =  ((long)A + ((long)B) + ((long)C));
                if(!hasNonD){
                    topVal = val;
                    mxA = A;
                    mxB = B;
                    mxC = C;
                    hasNonD = true;
                    continue;
                }
                if (val == topVal){
                    if(A > mxA){
                        topVal = val;
                        mxA = A;
                        mxB = B;
                        mxC = C;
                    }
                }
                else if(val > topVal){
                    topVal = val;
                    mxA = A;
                    mxB = B;
                    mxC = C;
                }
            }
        }
        if(!hasNonD) {
            ArrayList<Integer> myarr = new ArrayList();

            myarr.add(-1);
            return myarr;
        }

        ArrayList<Integer> myarr = new ArrayList<>();

        myarr.add(mxC);
        myarr.add(mxB);
        myarr.add(mxA);

        return myarr;
    }
}
