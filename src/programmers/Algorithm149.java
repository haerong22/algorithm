package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 * 광물 캐기
 */

public class Algorithm149 {
    public static void main(String[] args) {

        final int[] picks = {1, 3, 2};
        final String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
//        final int[] picks = {0, 1, 1};
//        final String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        System.out.println(new Solution().solution(picks, minerals));
    }

    static class Solution {

        public int solution(int[] picks, String[] minerals) {
            int answer = 0;

            Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) {
                    if (a[1] == b[1]) {
                        return b[2] - a[2];
                    }
                    return b[1] - a[1];
                }
                return b[0] - a[0];
            });

            int[] mineral = new int[3];
            int picksCnt = picks[0] + picks[1] + picks[2];
            for (int i = 1; i <= Math.min(minerals.length, 5 * picksCnt); i++) {
                switch (minerals[i - 1]) {
                    case "diamond": mineral[0] += 1; break;
                    case "iron": mineral[1] += 1; break;
                    case "stone": mineral[2] += 1; break;
                }

                if (i % 5 == 0) {
                    queue.add(mineral);
                    mineral = new int[3];
                }
            }
            queue.add(mineral);

            for (int i = 0; i < picks.length; i++) {
                for (int j = 0; j < picks[i]; j++) {
                    int[] m = queue.poll();
                    if (m == null) return answer;
                    answer += fatigue(i, m);
                }
            }

            return answer;
        }
        
        private int fatigue(int pick, int[] m) {
            return m[0] * (int) Math.pow(5, pick) + m[1] * (int) Math.pow(5, Math.max(pick - 1, 0)) + m[2] * (int) Math.pow(5, Math.max(pick - 2, 0));
        }
    }
}