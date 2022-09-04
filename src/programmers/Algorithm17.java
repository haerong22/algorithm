package programmers;

import java.util.Arrays;

/**
 * https://programmers.co.kr/
 * 실패율
 *
 * 실패율은 다음과 같이 정의한다.
 *   - 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 *
 * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages 가
 * 매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
 */

public class Algorithm17 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(solution(N, stages)));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] result = new double[N]; // 실패율 저장 배열
        // 스테이지 번호 정렬
        Arrays.sort(stages);
        int cnt = 0; // 도전중인 스테이지 번호가 몇명인지 세기 위한 변수
        int pre = stages[0]; // 도전중인 스테이지가 담긴 변수
        for (int i = 0; i < stages.length; i++) {
            // 현재 유저의 스테이지 번호가 이전의 스테이지 번호가 같으면 추가
            if(stages[i] == pre) {
                cnt++;
            } else {
                // 이전 스테이지 번호와 다르면 실패율을 계산하여 스테이지 번호에 맞는 인덱스에 저장
                result[pre - 1] = cnt /(double)(stages.length - i + cnt);
                pre = stages[i]; // 스테이지 번호를 저장
                cnt = 1; // 명수 추가
            }
            // 마지막 인덱스일 경우 이전 스테이지 번호와 비교하지 않으므로 결과를 실행해 준다.
            if(i == stages.length -1) {
                // 모든 스테이지를 완료한 유저는 제외
                if(pre < N+1) result[pre - 1] = cnt /(double)(stages.length - i + cnt);
            }
        }
        // 최대값을 찾아 answer배열에 저장하는 반복문
        for (int i = 0; i < result.length; i++) {
            double max = -1;
            int index = 0;
            // 최대 값을 찾아내서 그 때의 인덱스를 answer에 저장.
            for (int j = result.length -1; j >= 0; j--) {
                if(result[j] >= max) {

                    max = result[j];
                    index = j;
                }
            }
            result[index] = -1;
            answer[i] = index + 1;
        }

        return answer;
    }
}
