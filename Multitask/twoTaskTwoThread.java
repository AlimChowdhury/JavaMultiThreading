package Multitask;

class OddEven {
    private int count = 1;
     static int number;

    /**
     * Display odd value
     */
    public synchronized void displayOddNumber() {
        while (count < number) {
            while (count % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
            System.out.print(count + " ");
            count++;
            notifyAll();
        }
    }

    /**
     * Display even value
     */
    public synchronized void displayEvenNumber() {
        while (count < number) {
            while (count % 2 == 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
            System.out.print(count + " ");
            count++;
            notifyAll();
        }
    }
}

/**
 * Java program that prints the odd and even numbers using two threads.
 * The time complexity of the program is O(N), where N is the number up to which we are displaying the numbers.
 */
class TwoTaskTwoThread {
    public static void main(String[] args) {
        int number = 20;
        OddEven.number = number;

        OddEven oe = new OddEven();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                oe.displayOddNumber();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                oe.displayEvenNumber();
            }
        });

        thread1.start();
        thread2.start();

        try {
            // Wait for threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}