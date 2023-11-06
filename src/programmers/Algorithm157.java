package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72412
 * 순위 검색
 */

public class Algorithm157 {
    public static void main(String[] args) {

        final String[] info = {
                "java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"
        };
        final String[] query = {
                "java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"
        };

        System.out.println(Arrays.toString(new Solution().solution(info, query)));
    }

    static class Solution {

        private final Map<String, List<Integer>> map = new HashMap<>();

        public int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];

            for (String i : info) {
                String[] arr = i.split(" ");
                dfs("", arr, 0);
            }

            map.values().forEach(v -> v.sort(null));

            for (int i = 0; i < query.length; i++) {
                String[] s = query[i].replaceAll(" and ", "").split(" ");

                List<Integer> list = map.getOrDefault(s[0], new ArrayList<>());

                if (list.size() != 0) {

                    int left = 0;
                    int right = list.size();

                    while (left < right) {
                        int mid = (left + right) / 2;

                        if (list.get(mid) >= Integer.parseInt(s[1])) {
                            right = mid;
                        } else {
                            left = mid + 1;
                        }
                    }

                    answer[i] = list.size() - left;
                }

            }

            return answer;
        }

        private void dfs(String key, String[] arr, int depth) {
            if (depth == 4) {
                List<Integer> value = map.getOrDefault(key, new ArrayList<>());
                value.add(Integer.parseInt(arr[4]));
                map.put(key, value);
                return;
            }

            dfs(key + "-", arr, depth + 1);
            dfs(key + arr[depth], arr, depth + 1);
        }

    }
}