package google_foobar.challenge5;

import java.math.BigInteger;

public class BombBaby {

    public static void main(String[] args) {

        System.out.println(solution("10000000000000000000000000000000000000000000000000000000000000000","1335"));
    }

    public static String solution(String x, String y) {
        BigInteger firstNum = new BigInteger(x);
        BigInteger secondNum = new BigInteger(y);

        BigInteger min = firstNum.min(secondNum);
        BigInteger max = firstNum.max(secondNum);

        if (min.equals(BigInteger.ONE))
            return max.subtract(BigInteger.ONE).toString();

        if (max.mod(min).equals(BigInteger.ZERO))
            return "impossible";

        BigInteger result = whileSolution(max, min);

        if (result.equals(new BigInteger(String.valueOf(-1))))
            return "impossible";

        return String.valueOf(result);
    }

    public static BigInteger whileSolution(BigInteger high, BigInteger low) {
        BigInteger generation = BigInteger.ZERO;

        while(true) {
            BigInteger temp_low = low;
            low = high.subtract((high.divide(low)).multiply(low));
            generation = generation.add(high.divide(temp_low));
            high = temp_low;

            if (low.equals(BigInteger.ONE)) {
                generation = generation.add(high.subtract(BigInteger.ONE));
                break;
            } else if (low.compareTo(BigInteger.ONE) < 0)
                return new BigInteger(String.valueOf(-1));

        }

        return generation;
    }
}


