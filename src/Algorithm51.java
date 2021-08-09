import java.util.Arrays;
import java.util.HashMap;

/**
 * https://programmers.co.kr/
 * 위장
 *
 * ...
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요
 */

public class Algorithm51 {

    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        int limit = 100;
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> ootd = new HashMap<>();
        // 옷 종류별로 개수 세기
        for (String[] cloth : clothes) {
            if (ootd.containsKey(cloth[1])) {
                int num = ootd.get(cloth[1]);
                ootd.put(cloth[1], ++num);
            } else {
                ootd.put(cloth[1], 1);
            }
        }
        // 경우의 수 구하기
        for (int i : ootd.values()) {
            answer *= i+1;
        }
        return answer - 1;
    }
}
