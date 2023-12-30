package Sleep;

class sleepMethod extends Thread{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
}

class sleepMethodEx extends Thread{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            try{
                /** it throws the exception IllegalArgumentException as the time is -ive which is -500 */
                Thread.sleep(-500);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
}


public class sleep {
    public static void main(String[] args){
        sleepMethod sm1 = new sleepMethod();
        sleepMethodEx smx = new sleepMethodEx();
        sleepMethod sm2 = new sleepMethod();
        sm1.start();
        smx.start();
        sm2.start();
    }
}
