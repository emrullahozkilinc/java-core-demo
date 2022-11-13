package streams.optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Optional<String> opt = Optional.of("scaasc");
        main.run(opt);
    }


    void run(Optional<String> optString) {
        //optString.orElseThrow().stream().forEach(System.err::println)

    }
}


