package by.bsuir.part1;


import java.util.NoSuchElementException;

public class CustomQueueImpl<E> implements CustomQueue<E> {


    private Node front;

    private Node rear;

    private int size;


    public CustomQueueImpl(int sizeValue) {
        this.size = sizeValue;
        this.front = null;
        this.rear = null;

    }


    @Override
    public void push(E val) {
        Node<E> first = front;
        Node<E> newNode = new Node<>(first, val);
        first = newNode;
         if (first == null){
             rear = newNode;
         }
         size++;

    }

    @Override
    public E pop() {
        Node<E> last = rear;
        if (last == null){
            throw new NoSuchElementException("Rear element is null");
        }

        return unlinkLastElement(last);
    }


    public boolean isEmpty() {
        return this.front == this.rear;

    }

    public int size() {
        return size;
    }


    private class Node<E> {

        Node<E> next;

        E value;


        public Node(Node<E> next, E value) {
            this.next = next;
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public E getValue() {
            return value;
        }
    }


    private E unlinkLastElement(Node<E> last){

        E element = last.value;
        last.value = null;
        size --;
        return element;

    }


}



