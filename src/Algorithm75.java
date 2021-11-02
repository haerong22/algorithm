import java.util.Arrays;

/**
 * https://programmers.co.kr/
 * 튜플
 *
 * ...
 *
 * 특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때,
 * s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */

public class Algorithm75 {

    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        String[] elements = s.replaceAll("[{}]", " ").split(" ,");
        int[] answer = new int[elements.length];
        
        Arrays.sort(elements, (a, b) -> a.length() > b.length() ? 1 : -1);
        for (int i = 0; i < elements.length; i++) {
            String[] split = elements[i].trim().split(",");
            for (String num : split) {
                int n = Integer.parseInt(num);
                if (!isContain(n, answer)) {
                    answer[i] = n;
                    break;
                }
            }
        }
        return answer;
    }

    public static boolean isContain(int n, int[] arr) {
        for (int x : arr) {
            if (x == n) {
                return true;
            }
        }
        return false;
    }
}

