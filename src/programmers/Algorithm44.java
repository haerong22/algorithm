package programmers;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://programmers.co.kr/
 * 더 맵게
 *
 * ...
 * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
 * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
 */

public class Algorithm44 {

    public static void main(String[] args) {
        int[] scovile = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(scovile, 7));
    }


    public static int solution(int[] scoville, int K) {
        int answer = 0;
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(scoville); // 첫 배열 정렬
        for (int i : scoville) {
            list.add(i);
        }
        while(list.getFirst() < K) { // 배열의 첫 번째 수가 K보다 작을 때만 수행
            if(list.size() < 2) return -1; // 2보다 작을 경우 -1리턴

            int a = list.poll(); // 제일 작은 값
            int b = list.poll(); // 2번째로 작은 값
            int sum = a + (b * 2); // 계산
            answer++;

            if(list.isEmpty()) {
                return sum >= K ? answer : -1; // 리스트가 비어있을 경우 수행
            } else if(list.getLast() <= sum) {
                list.add(sum); // 가장 큰 값보다 크다면 가장 뒤에 삽입
            } else {
                // 정렬 하여 삽입
                for (int i = 0; i < list.size(); i++) {
                    if(sum < list.get(i)) {
                        list.add(i, sum);
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
