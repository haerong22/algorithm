package programmers;

import java.util.ArrayList;

/**
 * https://programmers.co.kr/
 * 피보나치 수
 *
 * 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
 */

public class Algorithm63 {

    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    public static int solution(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (i==0) arr.add(0);
            else if (i==1) arr.add(1);
            else arr.add((arr.get(i-1) + arr.get(i-2)) % 1234567);
        }
        return arr.get(n);
    }

}
