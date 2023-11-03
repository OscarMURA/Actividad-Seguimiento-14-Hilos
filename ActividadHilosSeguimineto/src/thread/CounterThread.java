package thread;
import model.Counter;

public class CounterThread extends Thread{

    private long sleepMills;
    private Counter counter;

    public CounterThread( Counter counter,long sleepMills) {
        this.sleepMills = sleepMills;
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.count();
    }

}
