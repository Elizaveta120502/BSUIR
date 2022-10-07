package by.bsuir.part1;

public class Node {

    Node next;
    String value;


    public Node(Node next, String st) {
        this.next = next;
        this.value = st;

    }

    public Node(Object o1, Object o2) {
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
