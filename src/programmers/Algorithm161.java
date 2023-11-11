package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1835
 * 단체사진 찍기
 */

public class Algorithm161 {
    public static void main(String[] args) {

        final int n = 2;
        final String[] data = {"N~F=0", "R~T>2"};
//        final String[] data = {"M~C<2", "C~M>1"};

        System.out.println(new Solution().solution(n, data));
    }

    static class Solution {

        private final String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
        private int answer = 0;
        private String[] data;
        private final boolean[] visited = new boolean[8];

        public int solution(int n, String[] data) {
            this.data = data;

            dfs("", 0);
            return answer;
        }

        private void dfs(String order, int depth) {
            if (depth == 8) {
                if (check(order)) answer++;
                return;
            }

            for (int i = 0; i < 8; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(order + friends[i], depth + 1);
                    visited[i] = false;
                }
            }
        }

        private boolean check(String order) {
            for (String d : data) {
                int a = order.indexOf(d.charAt(0));
                int b = order.indexOf(d.charAt(2));

                int dist = Math.abs(a - b) - 1;
                int val = Character.getNumericValue(d.charAt(4));
                char sign = d.charAt(3);

                if (sign == '=' && dist != val) return false;
                if (sign == '<' && dist >= val) return false;
                if (sign == '>' && dist <= val) return false;
            }
            return true;
        }
    }
}