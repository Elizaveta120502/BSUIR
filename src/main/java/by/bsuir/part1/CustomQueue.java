package by.bsuir.part1;

public class CustomQueue {


    Node head;

    Node current;

    int size;

    public CustomQueue() {

        this.head = current = new Node(null,null);
        this.size = 0;
        this.head.next = this.head;

    }


    public void index(int index) throws Exception {
        if (index < -1 || index > size - 1) {
            throw new Exception("Invalid parameter");

        }


        if (index == -1)
            return;
        current = head.next;
        int j = 0;
        while (current != head && j < index) {
            current = current.next;
            j++;

        }


    }

    public void delete(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty and can not be deleted");

        }
        if (index < 0 || index > size) {
            throw new Exception("Invalid parameter");

        }
        index(index - 1);
        current.setNext(current.next.next);
        size--;

    }


    public Object get(int index) {
        if (index < -1 || index > size - 1) {
            System.out.println("Invalid parameter");

        }
        try {
            index(index);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return current.getNext();

    }


    public void insert(int index, Object obj) throws Exception {

        if (index < 0 || index > size) {
            throw new Exception("Invalid parameter");

        }
        index(index - 1);
        current.setNext(new Node(obj, current.next));
        size++;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return this.size;
    }


}



