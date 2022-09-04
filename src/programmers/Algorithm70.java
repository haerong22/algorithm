package programmers;

/**
 * https://programmers.co.kr/
 * 타겟 넘버
 *
 * ...
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
 * 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 */

public class Algorithm70 {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        return find(numbers, target, numbers[0], 1)
                + find(numbers, target, -numbers[0], 1);
    }

    public static int find(int[] numbers, int target, int sum, int idx) {
        if(idx == numbers.length){
            return sum == target ? 1:0;
        }
        return find(numbers, target, sum+numbers[idx], idx+1)
                + find(numbers, target, sum-numbers[idx], idx+1);
    }
}
