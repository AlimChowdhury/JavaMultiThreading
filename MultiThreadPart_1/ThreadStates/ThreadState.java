package MultiThreadPart_1.ThreadStates;

class Processor implements Runnable{
    @Override
    public void run() {

        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("The state of thread t1 while it invoked the method join() on thread t2 -"
                + ThreadState.t1.getState());

        try {
            Thread.sleep(200);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}

public class ThreadState implements Runnable{
    public static Thread t1;
    public static ThreadState obj;

    public static void main(String[] args){
        obj = new ThreadState();
        t1 = new Thread(obj);

        System.out.println("The state of thread t1 after spawning it - " + t1.getState());
        t1.start();

// thread t1 is moved to the Runnable state
        System.out.println("The state of thread t1 after invoking the method start() on it - " + t1.getState());
    }

    @Override
    public void run() {
        Processor processor = new Processor();
        Thread t2 = new Thread(processor);

        System.out.println("The state of thread t2 after spawning it - "+ t2.getState());
        t2.start();

// thread t2 is moved to the runnable state
        System.out.println("the state of thread t2 after calling the method start() on it - " + t2.getState());

// try-catch block for the smooth flow of the  program
        try
        {
// moving the thread t1 to the state timed waiting
            Thread.sleep(200);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }

        System.out.println("The state of thread t2 after invoking the method sleep() on it - "+ t2.getState() );

// try-catch block for the smooth flow of the  program
        try
        {
// waiting for thread t2 to complete its execution
            t2.join();
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
        System.out.println("The state of thread t2 when it has completed it's execution - " + t2.getState());
    }

}
/**
 * In Java, a thread always exists in any one of the following states. These states are:
                         1 New
                         2 Active
                         3 Blocked / Waiting
                         4 Timed Waiting
                         5 Terminated
 *
 Explanation:
 * Whenever we spawn a new thread, that thread attains the new state.
 * When the method start() is invoked on a thread, the thread scheduler moves that thread to the runnable state.
 * Whenever the join() method is invoked on any thread instance, the current thread executing that statement has
   to wait for this thread to finish its execution, i.e., move that thread to the terminated state.
 * Therefore, before the final print statement is printed on the console,
   the program invokes the method join() on thread t2, making the thread t1 wait while the thread t2 finishes its
   execution and thus, the thread t2 get to the terminated or dead state.
 * Thread t1 goes to the waiting state because it is waiting for thread t2 to finish it is execution as it has
   invoked the method join() on thread t2.
 */