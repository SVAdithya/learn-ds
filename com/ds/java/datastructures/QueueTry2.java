package com.ds.java.datastructures;

public class QueueTry2 {
    static int front = 0, rear = 0, capacity = 10, size = 0;
    static int[] queue = new int[10];

    public static void main(String[] args) {
        print();
        enqueue(queue, 10);
        enqueue(queue, 20);
        enqueue(queue, 30);
        enqueue(queue, 60);
        dequeue(queue);
        enqueue(queue, 31);
        enqueue(queue, 32);
        enqueue(queue, 33);
        enqueue(queue, 34);

        dequeue(queue);
        dequeue(queue);
        dequeue(queue);
        dequeue(queue);
        dequeue(queue);
        dequeue(queue);
        dequeue(queue);
        dequeue(queue);
        dequeue(queue);
        dequeue(queue);
        enqueue(queue, 36);
        enqueue(queue, 37);
        enqueue(queue, 38);
        enqueue(queue, 39);
        enqueue(queue, 40);
        enqueue(queue, 41);
        enqueue(queue, 42);
        enqueue(queue, 43);
        enqueue(queue, 44);
        enqueue(queue, 45);
        enqueue(queue, 46);
        enqueue(queue, 47);
        enqueue(queue, 48);

    }

    static void enqueue(int[] arr, int data) {
        if (size == capacity) {
            System.out.println("Full");
        } else {
            arr[rear] = data;
            rear = (rear + 1) % capacity;
            size++;
        }
        print();
    }

    static void dequeue(int[] arr) {
        if (size == 0) {
            System.out.println("Empty");
        } else {
            arr[front] = 0;
            front = (front + 1) % capacity;
            size--;
        }
        print();
    }

    static void print() {
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != 0) System.out.print(" " + queue[i]);
            else System.out.print("  *");
            if (i == front)
                System.out.print("F");
            if (i == rear)
                System.out.print("R");
        }
        System.out.println();
    }
}
