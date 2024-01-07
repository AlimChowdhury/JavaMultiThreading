package Synchronization.StaticSynchronization;

/**
 *  In Java, when a method is declared as synchronized and static, it means that the synchronization is
 *  applied at the class level. This ensures that only one thread can execute the synchronized static method
 *  at a time for the entire class, rather than at the instance level.
 *
 *  The printTable method is declared as synchronized static. This means that the synchronization is applied
 *  to the class, and only one thread can execute any synchronized static method of the Table class at a time.
 */
class Table{
    synchronized static void printTable(int n){
        for(int i=0;i<10;i++){
            System.out.println(n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){}
        }
    }
}

class ThreadOne extends Thread{
    @Override
    public void run(){
        Table.printTable(1);
    }
}
class ThreadTwo extends Thread{
    @Override
    public void run(){
        Table.printTable(10);
    }
}
class ThreadThree extends Thread{
    @Override
    public void run(){
        Table.printTable(100);
    }
}
class ThreadFour extends Thread{
    @Override
    public void run(){
        Table.printTable(1000);
    }
}

public class staticSynchronization {
    public static void main(String[] args){
        ThreadOne t1 = new  ThreadOne();
        ThreadTwo t2 = new ThreadTwo();
        ThreadThree t3 = new ThreadThree();
        ThreadFour t4 = new ThreadFour();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
