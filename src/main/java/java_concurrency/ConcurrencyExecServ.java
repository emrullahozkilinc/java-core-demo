package java_concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * Thread kuyrukları, havuzları oluşturmamızı ve bunları await gibi metodlarla bekletmemizi,
 * shutdown() gibi metodlarla sonlandırmamızı sağlar.
 */
public class ConcurrencyExecServ {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);


        try {
            service.awaitTermination( 20l, TimeUnit.NANOSECONDS );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.submit(new Task());
    }
}

class Task implements Runnable{

    @Override
    public void run() {
        System.err.println("Task run running.");
    }
}
