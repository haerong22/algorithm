package programmers;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17679
 * [1차] 프렌즈4블록
 */

public class Algorithm123 {
    public static void main(String[] args) {

        final int m = 4;
        final int n = 5;
        final String[] board = {
                "CCBDE",
                "AAADE",
                "AAABF",
                "CCBBF"
        };

        System.out.println(new Solution().solution(m, n, board));
    }

    static class Solution {

        public int solution(int m, int n, String[] board) {
            int answer = 0;

            char[][] b = new char[m][n];

            for (int i = 0; i < m; i++) {
                b[i] = board[i].toCharArray();
            }

            while (true) {
                int remove = remove(b);
                if (remove == 0) break;
                answer += remove;
            }

            return answer;
        }

        private int remove(char[][] b) {
            Set<int[]> remove = new HashSet<>();

            for (int i = 0; i < b.length - 1; i++) {

                for (int j = 0; j < b[0].length - 1; j++) {

                    char block = b[i][j];

                    if (block == '-') continue;

                    if (block == b[i + 1][j]
                            && block == b[i][j + 1]
                            && block == b[i + 1][j + 1]) {
                        remove.add(new int[]{i, j});
                        remove.add(new int[]{i + 1, j});
                        remove.add(new int[]{i, j + 1});
                        remove.add(new int[]{i + 1, j + 1});
                    }
                }
            }

            AtomicInteger cnt = new AtomicInteger(0);

            remove.forEach(r -> {
                if (b[r[0]][r[1]] != '-') {
                    b[r[0]][r[1]] = '-';
                    cnt.incrementAndGet();
                }
            });

            for (int j = 0; j < b[0].length; j++) {
                int temp = 0;
                for (int i = b.length - 1; i >= 0; i--) {
                    if (b[i][j] == '-') {
                        temp++;
                    } else {
                        if (temp != 0) {
                            b[i + temp][j] = b[i][j];
                            b[i][j] = '-';
                        }
                    }
                }
            }

            return cnt.get();
        }
    }
}