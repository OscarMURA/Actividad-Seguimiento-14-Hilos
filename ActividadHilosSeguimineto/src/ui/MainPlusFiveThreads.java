package ui;
import thread.CounterThread;
import model.Counter;
import model.Timer;

public class MainPlusFiveThreads {

    public MainPlusFiveThreads() {
    }

    public static void main(String[] args) {
        MainPlusFiveThreads m1 = new MainPlusFiveThreads();
        m1.execute();
    }

    public void execute(){
        Timer timer = new Timer();
        CounterThread counterThread[] = new CounterThread[5];
        for (int i = 0; i < counterThread.length; i++) {
            Counter counter = new Counter(20*i+1, 20*i+20);
            counterThread[i] = new CounterThread(counter, 0);
        }
        timer.start();
        for (int i = 0; i < counterThread.length; i++) {
            counterThread[i].start();
        }
        for (int i = 0; i < counterThread.length; i++) {
            try {
                counterThread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Time: "+timer.stop()+" ms");
        //Lo utilizo solo para que no trabaje más hilos de los necesarios
        //con el sistema inactivo
        for(int i = 0; i < counterThread.length; i++) {
            counterThread[i].interrupt();
        }

    }




}
