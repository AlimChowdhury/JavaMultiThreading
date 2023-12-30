package VolatileKeyword_2;

import java.util.Scanner;

class Processor extends Thread{
    private volatile boolean running = true;

    public void run(){
        while (running){
            System.out.println("Running");

            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void shutdown(){
        running =false;
    }
}
public class App {
    public static void main(String[] args){
        Processor pro =new Processor();
        pro.start();
        System.out.println("Enter something to stop the thread,\n " +
                "Volatile variable running will be forced to true :");
        new Scanner(System.in).nextLine();
        pro.shutdown();
    }
}
