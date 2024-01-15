package com.aseemsavio.projectloom;

import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static java.lang.Thread.startVirtualThread;

public class FiveMillionChallenge {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Started");
        // startVirtualThreads_1_Million();
        startVirtualThreads_5_Million();
        System.out.println("Main Ended");
    }

    /**
     * Starting 1 Million Virtual Threads
     */
    private static void startVirtualThreads_1_Million() throws InterruptedException {
        var threads = new ArrayList<Thread>(1000000);
        for (int i = 0; i < 1000000; i++) {
            var thread = startVirtualThread(() -> {
                System.out.println(Thread.currentThread());
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Exception Occurred: " + e.getMessage());
                }
            });
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    /**
     * Starting 5 Million Virtual Threads
     */
    private static void startVirtualThreads_5_Million() throws InterruptedException {
        var threads = new ArrayList<Thread>(1000000);
        for (int i = 0; i < 1000000; i++) {
            var thread = startVirtualThread(() -> {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Exception Occurred: " + e.getMessage());
                }
            });
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

}
