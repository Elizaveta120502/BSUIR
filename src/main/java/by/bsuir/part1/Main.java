package by.bsuir.part1;

public class Main {
    public static void main (String [] args) {
        CustomQueue customQueue = new CustomQueue();
        try {
            customQueue.insert(0, "Anne");
            customQueue.insert(1, "Bob");
            customQueue.insert(2, "James");
            customQueue.insert(3, "Genry");
            customQueue.insert(4, "Emily");

        }catch (Exception e){
            e.printStackTrace();
        }

        for (int i=0; i < customQueue.size; i++){
            System.out.println(customQueue.get(i));
        }

    }
}
