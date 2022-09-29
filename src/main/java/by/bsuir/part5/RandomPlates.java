package by.bsuir.part5;

import java.util.Scanner;

public class RandomPlates {

    private static final String WHITE_SPACE = " ";
    private static final String DASH = "-";

    private static final int START_OF_LETTER_AMOUNT = 65;
    private static final int END_OF_LETTER_AMOUNT = 90;


    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N value. It is amount of plates.\n N = ");
        int N = 0;
        if (sc.hasNext()){
            N = sc.nextInt();
        }
        for (String s : createRandomPlates(N)){
            System.out.println(s);
        }


    }

    private static String[] createRandomPlates(int N){
        String st;
        String[] plates = new String[N];
        String firstLetter;
        String secondLetter;

        int firstPart = 0;
        int lastNumber = (int)Math.random()*7 +1;
        for (int i=0; i < N; i++){
             firstPart = (int) (Math.random()*9999) + 1000;
             firstLetter= generateLetter();
             secondLetter = generateLetter();
            st = String.valueOf(firstPart);
            st = st + WHITE_SPACE;
            st= st +firstLetter;
            st= st + secondLetter;
            st= st +DASH;
            st= st + String.valueOf(lastNumber);
            plates[i] = st;
        }
        return plates;

    }


    private static String generateLetter(){
        int index = (int)Math.random()*END_OF_LETTER_AMOUNT + START_OF_LETTER_AMOUNT;
        char c = (char) index;
        return String.valueOf(c);

    }
}
