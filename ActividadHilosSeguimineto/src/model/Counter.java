package model;

public class Counter {

    private long startNumber;
    private long endNumber;
    private long currentNumber;


    public Counter(long startNumber, long endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public void count() {
        for (long i = startNumber; i <= endNumber; i++) {
            currentNumber = i;
            System.out.println("Number: " + currentNumber);
        }
    }

    public long getCurrentNumber() {
        return currentNumber;
    }

    public long getStartNumber() {
        return startNumber;
    }

    public long getEndNumber() {
        return endNumber;
    }

}
