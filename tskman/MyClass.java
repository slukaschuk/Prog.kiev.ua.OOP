package tskman;


import java.lang.Thread;

public class MyClass {

    static class MyStop extends Thread {
        private TaskManager s;
        
        public MyStop(TaskManager s) {
            this.s = s;
        }
        
        public void run() {
            s.stop();
        }
    }
    
    static class MyTask1 implements Task {
        public void execute() {
            System.out.println("MyTask1");
        }
    }
    
    static class MyTask2 implements Task {
        public void execute() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {}
            
            System.out.println("MyTask2");
        }
    }
    
    public static void main(String[] args) {
        TaskManager m = new TaskManager();
        
        m.add(new MyTask2());
        m.add(new MyTask1());
        m.start();
        
        Runtime.getRuntime().addShutdownHook(new MyStop(m));
    }
}