package application;

public class Process implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runnable process was started " + i);
        }
    }
}
