package MultiThreadPart_1.CreateThread;

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

public class create {

    public static void main(String[] args){

        /** Thread */
        MyThread myThread = new MyThread();
        myThread.start();

        /** ADD Name */
        Thread myThreadName= new Thread("Thread name");
        myThreadName.start();
        String str = myThreadName.getName();
        System.out.println(str);


        /** Runnable */
        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();

        /** ADD Name */
        Thread myRunnableName = new Thread(new MyRunnable(),"Runnable name");
        myRunnableName.start();
        String str1 = myRunnableName.getName();
        System.out.println(str1);

    }
}
