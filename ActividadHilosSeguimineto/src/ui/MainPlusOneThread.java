package ui;
import thread.CounterThread;
import model.Counter;
import model.Timer;


public class MainPlusOneThread {


    public MainPlusOneThread() {
    }

    public static void main(String[] args) {

        Timer timer=new Timer();
        Counter counter = new Counter(0, 50);
        CounterThread counterThread= new CounterThread(new Counter(51,100),0);
        timer.start();
        counterThread.start();
        counter.count();
        try {
            counterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Time: "+timer.stop()+" ms");
        //Para cerrar todo proceso del hilo con seguridad
        counterThread.interrupt();
    }

}
