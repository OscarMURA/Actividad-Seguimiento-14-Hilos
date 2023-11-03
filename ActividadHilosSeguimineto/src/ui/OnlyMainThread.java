package ui;

import thread.CounterThread;
import model.Counter;
import model.Timer;
public class OnlyMainThread {

    public OnlyMainThread() {
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        Counter counter = new Counter(0, 100);
        timer.start();
        counter.count();
        System.out.println("Time: "+timer.stop()+" ms");

    }








}
