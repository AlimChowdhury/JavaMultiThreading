package MultiThreadPart_1.ThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class tasks implements Runnable{
    private String taskName;
    public tasks(String taskName){
        this.taskName =taskName;
    }

    @Override
    public void run(){

        try {
            for (int j = 0; j < 3; j++) {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh : mm : ss");
                if (j == 0) {
/**
 * prints the initialization time for every task
 */
                    System.out.println("Initialization time for the task name: "+ taskName +
                            " = " + simpleDateFormat.format(date));
                }
                else{
/**
 * prints the execution time for every task
 */
                    System.out.println("Time of execution for the task name: " + taskName +
                            " = " +simpleDateFormat.format(date));
                }
                Thread.sleep(1000);
            }
            System.out.println(taskName + " is complete.");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class threadPool2 {
    static final int MAX_TH = 3;
    public static void main(String[] args){
/**
 * Creating five new tasks
 */
        Runnable rb1 = new tasks("task 1");
        Runnable rb2 = new tasks("task 2");
        Runnable rb3 = new tasks("task 3");
        Runnable rb4 = new tasks("task 4");
        Runnable rb5 = new tasks("task 5");

/**
 * creating a thread pool with MAX_TH number of
 * threads size the pool size is fixed
 */
        ExecutorService executor = Executors.newFixedThreadPool(MAX_TH);

        executor.execute(rb1);
        executor.execute(rb2);
        executor.execute(rb3);
        executor.execute(rb4);
        executor.execute(rb5);
/**
 * pool is shutdown
 */
        executor.shutdown();
    }
}

/**
 * Explanation: It is evident by looking at the output of the program that tasks 4 and 5 are executed only when
 * the thread has an idle thread. Until then, the extra tasks are put in the queue.
 */