package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 * 롤케이크 자르기
 */

public class Algorithm124 {
    public static void main(String[] args) {

        final int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};

        System.out.println(new Solution().solution(topping));
    }

    static class Solution {

        public int solution(int[] topping) {
            int answer = 0;

            int[] f = new int[topping.length];
            int[] b = new int[topping.length];
            Set<Integer> fs = new HashSet<>();
            Set<Integer> bs = new HashSet<>();

            for (int i = 0; i < topping.length; i++) {
                fs.add(topping[i]);
                bs.add(topping[topping.length - 1 - i]);
                f[i] = fs.size();
                b[topping.length - 1 - i] = bs.size();
            }

            for (int i = 0; i < topping.length - 1; i++) {
                if (f[i] == b[i + 1]) answer++;
            }

            return answer;
        }
    }
}