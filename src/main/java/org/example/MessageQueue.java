package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue<T> {

    private Queue<T> queue = new LinkedList<>();
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void enqueue(T message) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(message);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T message = queue.poll();
        notifyAll();
        return message;
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}
