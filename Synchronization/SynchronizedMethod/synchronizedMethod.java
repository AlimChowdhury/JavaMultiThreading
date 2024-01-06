package Synchronization.SynchronizedMethod;


class table{

    /**
     * synchronized method
     */
    synchronized void printTable(int n){
        for(int i=1;i<=5;i++){
            System.out.println(n*i);

            try{
                Thread.sleep(400);
            }catch (Exception e){
                System.out.println(e);
            }

        }
    }
}
class threadOne extends Thread{
    table t;
    threadOne(table t){
        this.t = t;
    }
    @Override
    public void run() {
     t.printTable(5);
    }
}

class threadTwo extends Thread{
    table t;
    threadTwo(table t){
        this.t = t;
    }
    @Override
    public void run() {
        t.printTable(100);
    }
}

/**
 * Synchronization in Java is the capability to control the access of multiple threads to any shared resource.
 *
 * Java Synchronization is better option where we want to allow only one thread to access the shared resource.
 *
 * Concept of Lock in Java
 * Synchronization is built around an internal entity known as the lock or monitor. Every object has a lock
 * associated with it. By convention, a thread that needs consistent access to an object's fields has to acquire
 * the object's lock before accessing them, and then release the lock when it's done with them.
 *
 * From Java 5 the package java.util.concurrent.locks contains several lock implementations.
 *
 *
 * Java Synchronized Method
 * If you declare any method as synchronized, it is known as synchronized method.
 * Synchronized method is used to lock an object for any shared resource.
 * When a thread invokes a synchronized method, it automatically acquires the lock for that object and releases
 * it when the thread completes its task.
 */

public class synchronizedMethod {
    public static void main(String[] args){
        table obj = new table();
        threadOne one = new threadOne(obj);
        threadTwo two = new threadTwo(obj);
        one.start();
        two.start();
    }
}
