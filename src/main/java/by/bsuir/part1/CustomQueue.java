package by.bsuir.part1;


public interface CustomQueue<Integer> {

    void push(CustomQueueImpl.Node node);

    void pop();

    boolean isFull();

    boolean isEmpty();

}
