package by.bsuir.part5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.Scanner;

public class RandomPlates {

    private static final int START_OF_LETTER_AMOUNT = 65;
    private static final int END_OF_LETTER_AMOUNT = 90;


    private static int MIN_RANDOM_NUMBER = 1;
    private static int MAX_RANDOM_NUMBER = 7;
    private static int DIFF = MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER;

    private static int MIN_RANDOM_NUMBER_BIG = 0;
    private static int MAX_RANDOM_NUMBER_BIG = 9999;


    private static final Logger LOGGER = LogManager.getLogger(RandomPlates.class);


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Enter N value. It is amount of plates.\n N = ");
        int N = 0;
        if (sc.hasNext()) {
            N = sc.nextInt();
        }
        for (String s : createRandomPlates(N)) {
            LOGGER.info(s);
        }


    }

    private static String[] createRandomPlates(int n) {
        String st;
        String[] plates = new String[n];
        String firstLetter;
        String secondLetter;

        int firstPart;
        int lastNumber;
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            lastNumber = r.nextInt(DIFF + 1);
            lastNumber += MIN_RANDOM_NUMBER;
            firstPart = r.nextInt((MAX_RANDOM_NUMBER_BIG - MIN_RANDOM_NUMBER_BIG) + 1);
            firstPart += MIN_RANDOM_NUMBER_BIG;
            firstLetter = generateLetter();
            secondLetter = generateLetter();
            if (firstPart < 1000 && firstPart > 100){
                st = String.format("0"+"%d %s%s-%d",firstPart,firstLetter,secondLetter,lastNumber);
            }
            else if (firstPart < 100 && firstPart > 0){
                st = String.format("00"+"%d %s%s-%d",firstPart,firstLetter,secondLetter,lastNumber);
            }else {

                st = String.format("%d %s%s-%d", firstPart, firstLetter, secondLetter, lastNumber);
            }


            plates[i] = st;
        }
        return plates;

    }


    private static String generateLetter() {
        Random rand = new Random();
        int index = rand.nextInt((END_OF_LETTER_AMOUNT - START_OF_LETTER_AMOUNT) + 1);
        index += START_OF_LETTER_AMOUNT;
        char c = (char) index;
        return String.valueOf(c);

    }
}
