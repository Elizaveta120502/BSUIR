package by.bsuir.part8;

import by.bsuir.part2.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
//напишите регулярные выражения для 4 случаев
//1) содержит не менее трех последовательных едениц
//2) содержит подстроку 110
//3) содержит подстроку 1101100
//4) не содержит подстроку 110

public class RegularExpression {
    private static final Logger LOGGER = LogManager.getLogger(RegularExpression.class);

    public static void main (String args[]){
        final String REGEX_1 = ".*[1]{3,}.*";
        final String REGEX_2 = ".*(110).*";
        final String REGEX_3 = ".*(1101100).*";
        final String REGEX_4 = "^((?!110).)*";



        LOGGER.info("Enter phrase: ");
        Scanner sc = new Scanner(System.in);
        String str = null;
        str = sc.nextLine();

            if (str.matches(REGEX_1)) {
                LOGGER.info("Line contains 3 or more \"1\" ");
            }

            if (str.matches(REGEX_2)) {
                LOGGER.info("Line  contains \"110\"");
            }

            if (str.matches(REGEX_3)) {
                LOGGER.info("Line  contains \"1101100\"");
            }
            if (str.matches(REGEX_4)) {
                LOGGER.info("Line do not contains substring 110");
            }


    }
}
