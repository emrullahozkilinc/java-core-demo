package google_foobar.challenge3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MathDemo {
    public static void main(String[] args) {
        System.err.println(solution("1211",10));
    }

    public static int solution(String n, int b){
        String subtraction = n;
        Map<String, Integer> numberOfRepeat = new HashMap<>();

        boolean isThree = false;
        while (!isThree) {
            if (!numberOfRepeat.containsKey(subtraction))
                numberOfRepeat.put(subtraction,1);
            else
                numberOfRepeat.replace(subtraction, numberOfRepeat.get(subtraction)+1);

            if (numberOfRepeat.containsValue(3))
                isThree = true;

            subtraction = getSubtractionOfStringBaseB(subtraction,b);
        }
        return Long.valueOf(
                numberOfRepeat
                        .values()
                        .stream()
                        .filter(x->x==2).count())
                .intValue() + 1;
    }

    static String getSubtractionOfStringBaseB(String n, int b) {
        //sort digits
        char[] digits = n.toCharArray();
        Arrays.sort(digits);
        char[] sortedAsc = Arrays.copyOf(digits,digits.length);
        char[] sortedDesc = reverseChar(digits);


        //concatenate digits
        int lowValue = Integer.parseInt(concatDigits(sortedAsc), b);
        int highValue = Integer.parseInt(concatDigits(sortedDesc), b);


        //subtraction
        return subtract(highValue, lowValue, b, n.length());
    }

    static String subtract(int highValue, int lowValue, int base, int length) {
        String subtraction = Integer.toString((highValue-lowValue), base);
        StringBuilder sb = new StringBuilder(subtraction);
        int numberOfZeros = length - subtraction.length();
        char[] zeros = new char[numberOfZeros];
        for (int i = 0; i < numberOfZeros; i++) {
            zeros[i] = '0';
        }
        sb.insert(0,zeros);
        return sb.toString();
    }

    static char[] reverseChar(char[] arr) {
        for (int i = 0; i < ((arr.length)/2); i++) {
            char temp = arr[i];
            arr[i] = arr[(arr.length-1)-i];
            arr[(arr.length-1)-i] = temp;
        }

        return arr;
    }

    static String concatDigits(char[] digits) {
        StringBuilder sb = new StringBuilder();
        for(char digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }





    /*
    static int getHighestOfIntegerDigits(int n){
        List<Integer> digits = getDigits(n);
        digits.sort(Comparator.comparingInt(a -> a));
        return 0;
    }

    static List<Integer> getDigits(int n){
        List<Integer> digits = new ArrayList<>();
        while (n>0){
            digits.add(n%10);
            n=n/10;
        }
        return digits;
    }
    */




    // 12 23 34 23 34 23 34

    /*
    1211 0999 8991 8082 8532 6174


     */
}
