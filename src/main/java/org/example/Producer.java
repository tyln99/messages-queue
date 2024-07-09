package org.example;

public class Producer implements Runnable {

    private MessageQueue<String> queue;

    public Producer(MessageQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            int messageNumber = 0;

            while (true) {
                String message = "Message " + messageNumber++;
                queue.enqueue(message);
                System.out.println("Produced: " + message);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
