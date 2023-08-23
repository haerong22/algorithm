package programmers;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/160586
 * 대충 만든 자판
 */

public class Algorithm87 {
    public static void main(String[] args) {
        final String[] keymap = {"AGZ", "BSSS"};
        final String[] targets = {"ASA","BGZ"};

        System.out.println(Arrays.toString(new Solution().solution(keymap, targets)));
    }

    static class Solution {

        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];

            HashMap<Character, Integer> keyCount = new HashMap<>();

            for (String key : keymap) {
                for (int i = 0; i < key.length(); i++) {
                    char c = key.charAt(i);
                    if (!keyCount.containsKey(c) || i < keyCount.get(c)) {
                        keyCount.put(c, i + 1);
                    }
                }
            }

            for (int i = 0; i < targets.length; i++) {
                int cnt = 0;
                for (int j = 0; j < targets[i].length(); j++) {
                    char c = targets[i].charAt(j);
                    if (!keyCount.containsKey(c)) {
                        cnt = -1;
                        break;
                    }
                    cnt += keyCount.get(c);
                }
                answer[i] = cnt;
            }

            return answer;
        }
    }
}