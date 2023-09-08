package programmers;

import java.util.Scanner;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181952
 * 문자열 출력하기
 */

public class Algorithm103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int a = str.length();

        if(a >= 1 && a <= 1000000) {
            System.out.println(str);
        }
    }
}