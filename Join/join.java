package Join;
class ThreadJoin extends Thread{
    @Override
    public void run() {
        for(int i=0;i<2;i++){
            try{
                Thread.sleep(500);
                System.out.println("The current thread name is: " + Thread.currentThread().getName() +" value: "+ i);
            }catch (InterruptedException e){
                System.out.println("The exception has been caught: " + e);
            }
        }
    }
}
/**
 * join(): When the join() method is invoked, the current thread stops its execution and the thread goes into the
 * wait state. The current thread remains in the wait state until the thread on which the join() method is invoked
 * has achieved its dead state. If interruption of the thread occurs, then it throws the InterruptedException.
 */
public class join {
    public static void main(String[] args){

        ThreadJoin one = new ThreadJoin();
        ThreadJoin two = new ThreadJoin();
        ThreadJoin three = new ThreadJoin();

        /**
         * 1st thread
         */
        one.start();
/**
 * starting the 2nd thread after when
 * the first thread one has ended or died.
 */

        try
        {
            System.out.println("The current thread name is: "+ Thread.currentThread().getName());
/**
 *  invoking the join() method
 */
            one.join();
        }

// catch block for catching the raised exception
        catch(Exception e)
        {
            System.out.println("The exception has been caught " + e);
        }
        /**
         *  2nd thread
         */
        two.start();

        /**
         * 3rd thread
         */
        three.start();

    }
}
