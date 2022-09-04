package programmers;

import java.util.Arrays;

/**
 * https://programmers.co.kr/
 * 이상한 문자 만들기
 *
 * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
 * 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution 을 완성하세요.
 */

public class Algorithm8 {
    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }

    public static String solution(String s) {
        char[] arr = s.toCharArray();
        int idx = 0;
        for(int i=0; i < arr.length; i++) {
            if(arr[i] == 32) {
                idx = 0;
            } else {
                if (idx % 2 == 0) {
                    arr[i] = Character.toUpperCase(arr[i]);
                } else {
                    arr[i] = Character.toLowerCase(arr[i]);
                }
                idx++;
            }
        }
        return String.valueOf(arr);
    }
}
