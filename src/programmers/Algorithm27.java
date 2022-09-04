package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/
 * 다리를 지나는 트럭
 *
 * 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
 * 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
 * ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
 */

public class Algorithm27 {
    public static void main(String[] args) {
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(2, 10, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>(); // 다리위를 지나는 트럭
        // truck : 다리위에 있는 트럭의 무게, idx : 트럭들의 인덱스, done : 다리를 지나간트럭의 개수
        int truck = 0, idx = 0, done = 0;
        while(done != truck_weights.length) {
            // 큐의 길이가 다리의 길이와 같아지면 poll
            if(q.size() == bridge_length) {
                int w = q.poll();
                // 그 값이 0이 아닐 경우 트럭이 다리를 완전히 건넌다.
                if(w != 0) {
                    truck -= w;
                    done++;
                }
            }
            // 다리가 견딜 수 있는 무게인지 판단
            if( idx < truck_weights.length && truck + truck_weights[idx] <= weight) {
                q.offer(truck_weights[idx]); // 트럭 추가
                truck += truck_weights[idx]; // 다리위의 트럭들의 무게
                idx++;
            } else {
                q.offer(0); // 0은 트럭이 아닌경우
            }
            answer++; // 1초 추가
        }
        return answer;
    }
}
