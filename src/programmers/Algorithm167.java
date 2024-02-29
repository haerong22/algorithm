package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250121
 * <p>
 * [PCCE 기출문제] 10번 / 데이터 분석
 */
public class Algorithm167 {
    public static void main(String[] args) {

        int[][] data = {
                {1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}
        };

        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";

        System.out.println(Arrays.deepToString(new Solution().solution(data, ext, val_ext, sort_by)));
    }

    static class Solution {

        public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
            Map<String, Integer> map = Map.of("code", 0, "date", 1, "maximum", 2, "remain", 3);

            return Arrays.stream(data)
                    .filter(d -> d[map.get(ext)] < val_ext)
                    .sorted(Comparator.comparingInt(a -> a[map.get(sort_by)]))
                    .collect(Collectors.toList())
                    .toArray(int[][]::new);
        }

    }
}