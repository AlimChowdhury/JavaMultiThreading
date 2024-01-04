package MultiThreadPart_1.ThreadPriority;
class priority extends Thread{
    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName() +
                           " Thread priority " + Thread.currentThread().getPriority());
    }
}
public class threadPriority {
    public static void main(String[] args){
        priority pr1 = new priority();

/**
 * * Default priority of a thread is 5 (NORM_PRIORITY).
 */

        System.out.println("Thread name: " + Thread.currentThread().getName() +
                " Thread priority " + Thread.currentThread().getPriority());

/**
 * public final void setPriority(int newPriority): The java.lang.Thread.setPriority() method updates or assign
 * the priority of the thread to newPriority.
 */
        priority pr2 = new priority();
        priority pr3 = new priority();

        pr1.setPriority(2);
        pr2.setPriority(4);
        pr3.setPriority(9);

/**
 * 3 constants defined in Thread class:
 * public static int MIN_PRIORITY -> The value of MIN_PRIORITY is 1
 * public static int NORM_PRIORITY
 * public static int MAX_PRIORITY -> the value of MAX_PRIORITY is 10.
 * Default priority of a thread is 5 (NORM_PRIORITY).
 */
        priority pr4 = new priority();
        priority pr5 = new priority();

        pr4.setPriority(Thread.MIN_PRIORITY);
        pr5.setPriority(Thread.MAX_PRIORITY);

        pr4.start();
        pr5.start();


/**
 * The method throws IllegalArgumentException if the value newPriority
 * goes out of the range, which is 1 (minimum) to 10 (maximum).
 */
        priority pr6 = new priority();
        try {
            /**
             *  Attempt to set the priority to 11 (which is out of the valid range).
             */
            pr6.setPriority(11);
        } catch (IllegalArgumentException e) {
            /**
             * Handle the exception: print a message or take appropriate action.
             */
            System.out.println("Exception caught: " + e.getMessage());
            /**
             * You might want to set a default priority or perform other error-handling logic here.
             */
        }
        pr6.start();
    }
}
