package bankconcurrent;

import java.util.concurrent.Semaphore;

class Account {
    private int money;

    public Account(int money) {
        this.money = money;
    }

    public int get() {
        return money;
    }

    public void set(int money) {
        this.money = money;
    }
}

class Transaction extends Thread {
    private Account account;
    private int withdraw;
    private Semaphore sem;

    public Transaction(Account account, int withdraw, Semaphore sem) {
        this.account = account;
        this.withdraw = withdraw;
        this.sem = sem;
    }

    public void run() {
        try {
            sem.acquire();
            int total = account.get();
            if (total >= withdraw)
                account.set(total - withdraw);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem.release();
    }
}

