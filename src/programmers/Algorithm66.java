package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://programmers.co.kr/
 * 후보키
 *
 * ...
 * 릴레이션을 나타내는 문자열 배열 relation이 매개변수로 주어질 때, 이 릴레이션에서 후보 키의 개수를 return 하도록 solution 함수를 완성하라.
 */

public class Algorithm66 {

    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };
        System.out.println(solution(relation));
    }

    static List<Integer> key = new ArrayList<>();

    public static int solution(String[][] relation) {
        int n = relation.length, m = relation[0].length;

        for (int k = 1; k < (1 << m); k++) {
            if (!min(k)) continue;

            Set<String> set = new HashSet<>();
            for (String[] strings : relation) {
                StringBuilder key = new StringBuilder();

                for (int j = 0; j < m; j++) {
                    if (((1 << j) & k) > 0) key.append(strings[j]).append('/');
                }

                if (!set.add(key.toString())) break;
            }
            if (set.size() == n) key.add(k);
        }
        return key.size();
    }

    static boolean min(int i) {
        for (int k : key)
            if ((k & i) == k) return false;
        return true;
    }

}
