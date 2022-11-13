package java_concurrency;

import java.util.concurrent.Executor;
/*
-Thread parçacıklarımızı değişkenlerde tutmamızı sağlar.
-Yapılacak işi, işin nasıl yapılacağından ayırır.
 */
public class ConcurrencyExecutor {
    public static void main(String[] args) {
        Executor executor = new Invoker();
        executor.execute( () -> {
            System.out.println("sad");
        });
        ConcurrencyExecutor ce = new ConcurrencyExecutor();
        new Thread(ce::printSomething).start();
    }

    boolean printSomething() {
        System.err.println("worked");
        return true;
    }
}

class Invoker implements Executor{
    @Override
    public void execute(Runnable command) {
        command.run();
        command.run();
    }
}
