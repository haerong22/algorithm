package programmers;

import java.util.HashSet;

/**
 * https://programmers.co.kr/
 * 폰켓몬
 *
 * ...
 * 당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에, 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다.
 * N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때,
 * N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아,
 * 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.
 */

public class Algorithm29 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 2};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int cnt = nums.length/2;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return Math.min(cnt, set.size());
    }
}
