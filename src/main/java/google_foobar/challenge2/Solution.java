package google_foobar.challenge2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] result = solution(new String[]{"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"});

        for(String res : result){
            System.out.println(res);
        }
    }

    public static String[] solution(String[] l) {
        return Arrays
                .stream(l)
                .sorted(Solution::stringComparator)
                .toArray(String[]::new);
    }


    static int stringComparator(String x, String y) {
        int[] splittedX = splitToInt(x);
        int[] splittedY = splitToInt(y);

        if(splittedX[0]>splittedY[0])
            return 1;
        else if(splittedX[0]<splittedY[0])
            return -1;
        else if(splittedX.length>1 && splittedY.length>1) {
            if(splittedX[1] > splittedY[1])
                return 1;
            else if(splittedX[1] < splittedY[1])
                return -1;
            else if(splittedX.length > 2 && splittedY.length > 2) {
                if (splittedX[2] > splittedY[2])
                    return 1;
                else
                    return -1;
            }
        }

        return splittedX.length > splittedY.length ? 1:-1;

    }

    static int[] splitToInt(String str){
        return Arrays
                .stream(str.split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
