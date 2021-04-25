import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * https://programmers.co.kr/
 * 두 개 뽑아서 더하기
 *
 * 정수 배열 numbers 가 주어집니다.
 * numbers 에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를
 * 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 */

public class Algorithm14 {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < numbers.length -1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                s.add(numbers[i] + numbers[j]);
            }
        }
        return s.stream().sorted().mapToInt(v->v).toArray();
    }
}
