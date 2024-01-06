package Synchronization.SynchronizedBlock;

/**
 * A Sender class
 */
class Sender{
    public void senderMsg(String msg){
        System.out.println("\nSending a Message: "  + msg);
        try {
            Thread.sleep(800);
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("\n" +msg+ " Sent");
    }
}

/**
 * A Sender class for sending a message using Threads
 */
class senderThread extends Thread {
    private String msg;
    Sender sender;

    /**
     * Receiver method to receive a message object and a message to be sent
      * @param msg
     * @param sender
     */
    senderThread(String msg, Sender sender) {
        this.msg = msg;
        this.sender = sender;
    }

    @Override
    public void run() {
/**
 * Checks that only one thread sends a message at a time.
 */
        synchronized (sender) {
            /**
             *   // synchronizing the sender object
             */
            sender.senderMsg(msg);
        }
    }
}

/**
 * * Synchronized block :
 * Synchronized block can be used to perform synchronization on any specific resource of the method.
 *
 * Suppose we have 50 lines of code in our method, but we want to synchronize only 5 lines, in such cases, we can
 * use synchronized block.
 * If we put all the codes of the method in the synchronized block, it will work same as the synchronized method.
 *
 * Points to Remember :
 * Synchronized block is used to lock an object for any shared resource.
 * Scope of synchronized block is smaller than the method.
 * A Java synchronized block doesn't allow more than one JVM, to provide access control to a shared resource.
 * The system performance may degrade because of the slower working of synchronized keyword.
 * Java synchronized block is more efficient than Java synchronized method.
 */
public class synchronizedBlock {
    public static void main(String[] args){
        Sender sender = new Sender();

        senderThread senderOne = new senderThread("Hi",sender);
        senderThread senderTwo  = new senderThread("Hey", sender);

/**
 * Start two threads of SenderThreads type
 */
        senderOne.start();
        senderTwo.start();

/**
 * wait for threads to end
 */
        try {
            senderOne.join();
            senderTwo.join();
        } catch(Exception e) {
            System.out.println("Interrupted");
        }

    }
}
