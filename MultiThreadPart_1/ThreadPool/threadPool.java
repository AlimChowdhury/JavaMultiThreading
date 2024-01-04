package MultiThreadPart_1.ThreadPool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class workerThread implements Runnable{
    private String message;
   public workerThread(String message){
        this.message = message;
    }
    private void processMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
        processMessage();//call processMessage method that sleeps the thread for 2 seconds
        System.out.println(Thread.currentThread().getName() + " (End)");//prints thread name
    }
}


/**
 * Java Thread pool represents a group of worker threads that are waiting for the job and reused many times.
 *
 * In the case of a thread pool, a group of fixed-size threads is created. A thread from the thread pool is
 * pulled out and assigned a job by the service provider. After completion of the job, the thread is contained
 * in the thread pool again.
 */

public class threadPool {
    public static void main(String[] args){

/**
 * creating a pool of 5 threads
 */
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++) {
            Runnable worker = new workerThread("" + i);
            executor.execute(worker);//calling execute method of ExecutorService
        }
        executor.shutdown();

        while (!executor.isTerminated()) {}

        System.out.println("Finished all threads");
    }
}

/**
 * Explanation:
 *
 * when one wants to execute 50 tasks but is not willing to create 50
 * threads. In such a case, one can create a pool of 10 threads. Thus, 10 out of 50 tasks are assigned, and the
 * rest are put in the queue. Whenever any thread out of 10 threads becomes idle, it picks up the 11th task.
 * The other pending tasks are treated the same way.
 */
