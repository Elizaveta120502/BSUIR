package by.bsuir.part1;


import java.util.NoSuchElementException;

public class CustomQueueImpl implements CustomQueue<Integer> {


    private Node front;

    private Node rear;

    private int size;

    private Node items[];

    public CustomQueueImpl(int sizeValue) {
        this.size = sizeValue;
        this.front = null;
        this.rear = null;
        this.items = new Node[this.size];

    }

    public CustomQueueImpl() {
    }


    @Override
    public void push(Node node) {
        if (this.isFull()) {
            throw new NoSuchElementException();
        }
        this.rear.next = node;
        this.items[this.size] = node;

    }

    @Override
    public void pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        this.front = front.next;
        this.size = size - 1;

    }

    @Override
    public boolean isFull() {
        return this.size() == (this.size - 1);
    }

    public boolean isEmpty() {
        return this.front == this.rear;

    }

    public int size() {
        return (this.rear.getValue() + this.size - this.front.getValue()) % this.size;
    }



    public class Node {

        Node next;

        Integer value;


        public Node(Node next, Integer value) {
            this.next = next;
            this.value = value;
        }

        public Node(Integer value) {
            this.value = value;
        }


        public Node() {
        }

        public Node getNext() {
            return next;
        }

        public Integer getValue() {
            return value;
        }


    }



}



