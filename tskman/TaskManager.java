package tskman;


import java.lang.Thread;
import java.lang.InterruptedException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TaskManager {
	
	private TaskThread thread;
    private Queue<Task> queue = new ConcurrentLinkedQueue<Task>();
    private int limit = 10;
    private boolean async = true;
    
    public boolean add(Task task) {
        if (queue.size() + 1 > limit)
            return false;
            
        queue.add(task);
        return true;
    }
    
    public boolean getAsync() {
        return async;
    }
    
    public void setAsync(boolean value) {
        async = value;
    }
    
    public void start() {
        thread = new TaskThread();
        thread.start();
    }
    
    public void stop() {
        thread.interrupt();
    }
    
    // ------------------------------------------ //
	
    private class TaskThread extends Thread {
        
        public void run() {
            while ( ! isInterrupted()) {
                final Task task = queue.poll();
                
                if (task != null) {
                    if ( ! async) {
                        task.execute();
                    } else {
                        Thread r = new Thread() {
                            public void run() {
                                task.execute();
                            }
                        };
                        r.start();
                    }
                }
                
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    return;
                }
            }
        }
    }
}