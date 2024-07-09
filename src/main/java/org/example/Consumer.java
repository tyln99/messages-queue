package org.example;

public class Consumer implements Runnable {

    private MessageQueue<String> queue;

    public Consumer(MessageQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = queue.dequeue();
                System.out.println("Consumed: " + message);
                Thread.sleep(150); // Simulate time taken to consume the message
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
