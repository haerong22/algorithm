package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12936
 * 줄 서는 방법
 */

public class Algorithm138 {
    public static void main(String[] args) {

        final int n = 3;
        final int k = 5;
        System.out.println(Arrays.toString(new Solution().solution(n, k)));
    }

    static class Solution {

        public int[] solution(int n, long k) {
            int[] answer = new int[n];

            List<Integer> people = new ArrayList<>();

            long total = 1;
            for (int i = 1; i <= n; i++) {
                people.add(i);
                total *= i;
            }

            k--;

            int idx = 0;
            while (idx < n) {
                total /= n - idx;
                answer[idx++] = people.remove((int) (k / total));
                k %= total;
            }

            return answer;
        }
    }
}