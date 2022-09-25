package by.bsuir.part2;


import java.util.*;


/*напишите программу, которая читает
из стандартного ввода список слов и выводит все составные
слова, состоящие из двух слов.*/

public class Main {
    public static void main(String [] args){
        String pattern;


        System.out.println("Enter words list");
        Scanner sc = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> sublist = new ArrayList<>();
        ArrayList<String> finalList = new ArrayList<>();



        while (sc.hasNext()){
            pattern = sc.next();
            if (pattern.equals("end")){
                break;
            }
            list.add(pattern);
            sublist.add(pattern);
        }




        for (int i =0 ; i < list.size(); i ++) {
            for (int j = 0; j < sublist.size(); j++) {
                List<Integer> foundIndexes = KMPSearch(list.get(i), sublist.get(j));
                if (list.get(i).equals(sublist.get(j))) {
                    break;
                }
                if (!foundIndexes.isEmpty()) {
                    finalList.add(list.get(i));
                }
            }

        }


        for (int i =0 ; i < list.size(); i ++) {
            for (int j = 0; j < sublist.size(); j++) {
                List<Integer> foundIndexes = KMPSearch(list.get(j), sublist.get(i));
                if (list.get(i).equals(sublist.get(j))) {
                    break;
                }
                if (!foundIndexes.isEmpty()) {
                    finalList.add(list.get(j));
                }
            }

        }


        for (int i =0; i < finalList.size(); i ++){
            for (int j=i+1; j < finalList.size();j++){
                if(finalList.get(i).equals(finalList.get(j))){
                    finalList.remove(finalList.get(j));
                }
            }
        }
        for (String s : finalList) {
            System.out.println(s);
        }


    }





    public static int[] compilePatternArray(String pattern){
        int patternLength = pattern.length();
        int len = 0;
        int i = 1;
        int[] compliedPatternArray = new int[patternLength];
        compliedPatternArray[0] = 0;

        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                compliedPatternArray[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = compliedPatternArray[len - 1];
                } else {
                    compliedPatternArray[i] = len;
                    i++;
                }
            }
        }
            return compliedPatternArray;
    }


    public static List<Integer> KMPSearch (String text, String pattern){
        int[] compliedPatternArray = compilePatternArray(pattern);

        int textIndex = 0;
        int patternIndex = 0;

        List<Integer> foundIndexes = new ArrayList<>();

        while (textIndex < text.length()) {
            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                patternIndex++;
                textIndex++;
            }
            if (patternIndex == pattern.length()) {
                foundIndexes.add(textIndex - patternIndex);
                patternIndex = compliedPatternArray[patternIndex - 1];
            }

            else if (textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                if (patternIndex != 0)
                    patternIndex = compliedPatternArray[patternIndex - 1];
                else
                    textIndex = textIndex + 1;
            }
        }
        return foundIndexes;
    }

}
