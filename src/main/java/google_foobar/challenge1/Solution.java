package google_foobar.challenge1;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] firstArr = {2,4,25,7,2,7,5,85,32,75,24,42,66};
        int[] secondArr = {7,75,85,5,2,99,66,4,7,24,42,25,2,32};

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);


        System.out.println(solution(firstArr,secondArr));
    }

    public static int solution(int[] x, int[] y) {
        return x.length > y.length ? find(x,y) : find(y,x);
    }

    static int find(int[] a, int[] b){
        for (int i = 0; i < b.length; i++) {
            if(a[i] != b[i])
                return a[i];
        }
        return a[a.length-1];
    }
}