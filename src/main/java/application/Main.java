package application;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {

        Thread thread3 = new Thread(() -> System.out.println("Thread 3"));
        thread3.start();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 5; i++) {
                        System.out.println("Thread 1 " + i);
//                        Thread.yield();
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.setDaemon(true);
        thread1.start();
        thread1.setPriority(Thread.MIN_PRIORITY);

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 2 " + i);
//                    try {
//                        sleep(500);
//                        this.interrupt();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };
        thread2.start();
        thread2.setPriority(Thread.MAX_PRIORITY);

        Process process = new Process();
        System.out.println(thread1.isDaemon());

        process.run();
    }
}
