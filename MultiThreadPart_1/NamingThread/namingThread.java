package MultiThreadPart_1.NamingThread;

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread is running...");
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("MyRunnable is running...");
    }
}

/**
 * The Thread class provides methods to change and get the name of a thread. By default, each thread has a name,
 * i.e. thread-0, thread-1 and so on. By we can change the name of the thread by using the setName() method.
 * The syntax of setName() and getName() methods are given below:
 *
 * public String getName(): is used to return the name of a thread.
 * public void setName(String name): is used to change the name of a thread.
 */

public class namingThread {
    public static void main (String[] args){

        MyThread threadName = new MyThread();
        threadName.start();
        System.out.println("Name of threadName:"+threadName.getName());

        threadName.setName("New Name");
        System.out.println("Name of threadName:"+threadName.getName());

    }
}
