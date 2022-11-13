package google_foobar.challenge4;

public class XORDemo {
    public static void main(String[] args) {
        System.err.println(solution(17,4));
    }

    public static int solution(int start, int length) {
        int result = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if((j+i+1) <= length)
                    result ^= (i*length)+start+j;
            }
        }
        return result;
    }
}
