package by.bsuir.part7;

import java.util.Scanner;

// реализуйте поиск подстроки BruteForceRL, которая просматривает образец справа налево
public class BruteForceRL {
    private int[] right;
    private String pat;

    public BruteForceRL(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int i = 0; i < R; i++) {     //инициализируем массив значениями -1
            right[i] = -1;
        }
        for (int j = 0; j < M; j++) {
            right[pat.charAt(j)] = j;
        }


    }

    public int search(String txt) {
        int N = txt.length();
        int M = pat.length();
        int skip;

        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1) {
                        skip = 1;
                        break;
                    }
                    if (skip == 0) {
                        return i;
                    }
                }
            }
        }
        return N;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите образец:");
        String pat = sc.next();
        System.out.println("Введите текст:");
        String txt = sc.next();
        BruteForceRL br = new BruteForceRL(pat);
        System.out.println("текст: " + txt);
        int offset = br.search(txt);
        System.out.print("образец: ");
        for (int i = 0; i < offset; i++) {
            System.out.println(pat);
        }

    }
}
