package bankconcurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class AccountSync {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        Account acc = new Account(1000);
        ExecutorService ex = Executors.newFixedThreadPool(1);

        ex.execute(new Transaction(acc, 100, sem));
        ex.execute(new Transaction(acc, 500, sem));
        ex.execute(new Transaction(acc, 200, sem));
        ex.execute(new Transaction(acc, 150, sem));
        ex.execute(new Transaction(acc, 50, sem));

        ex.shutdown();

        //
        System.out.println("Total: " + acc.get());
    }
}
