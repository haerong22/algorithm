package programmers;

import java.util.*;

/**
 * https://programmers.co.kr/
 * 복서 정렬하기
 *
 * 문제 설명
 * 복서 선수들의 몸무게 weights와, 복서 선수들의 전적을 나타내는 head2head가 매개변수로 주어집니다.
 * 복서 선수들의 번호를 다음과 같은 순서로 정렬한 후 return 하도록 solution 함수를 완성해주세요.
 *
 * 전체 승률이 높은 복서의 번호가 앞쪽으로 갑니다. 아직 다른 복서랑 붙어본 적이 없는 복서의 승률은 0%로 취급합니다.
 * 승률이 동일한 복서의 번호들 중에서는 자신보다 몸무게가 무거운 복서를 이긴 횟수가 많은 복서의 번호가 앞쪽으로 갑니다.
 * 자신보다 무거운 복서를 이긴 횟수까지 동일한 복서의 번호들 중에서는 자기 몸무게가 무거운 복서의 번호가 앞쪽으로 갑니다.
 * 자기 몸무게까지 동일한 복서의 번호들 중에서는 작은 번호가 앞쪽으로 갑니다.
 */

public class Algorithm68 {

    public static void main(String[] args) {
        int[] weights = {60, 70, 60};
        String[] head2head = {"NNN","NNN","NNN"};
        System.out.println(Arrays.toString(solution(weights, head2head)));
    }
    public static int[] solution(int[] weights, String[] head2head) {
        int total = weights.length;
        int[] answer = new int[total];
        Boxer[] boxers = new Boxer[total];
        for (int i = 0; i < total; i++) {
            int wins = 0;
            int games = 0;
            int over = 0;
            for (int j = 0; j < total; j++) {
                int result = head2head[i].charAt(j);
                if (result != 'N') games++;
                if (result == 'W') {
                    wins++;
                    if (weights[i] < weights[j]) {
                        over++;
                    }
                }
            }
            Boxer boxer = new Boxer(games == 0 ? 0 : (double) wins/games, over, i+1, weights[i]);
            System.out.println("boxer = " + boxer);
            boxers[i] = boxer;
        }
        Arrays.sort(boxers);
        for (int i = 0; i < total; i++) {
            answer[i] = boxers[i].index;
        }
        return answer;
    }

    public static class Boxer implements Comparable<Boxer> {
        double winRate;
        int over;
        int index;
        int weight;

        @Override
        public String toString() {
            return "Boxer{" +
                    "winRate=" + winRate +
                    ", over=" + over +
                    ", index=" + index +
                    ", weight=" + weight +
                    '}';
        }

        public Boxer(double winRate, int over, int index, int weight) {
            this.winRate = winRate;
            this.over = over;
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Boxer b) {
            if (this.winRate > b.winRate) {
                return -1;
            } else if (this.winRate == b.winRate) {
                if (this.over > b.over) {
                    return -1;
                } else if (this.over == b.over) {
                    if (this.weight > b.weight) {
                        return -1;
                    } else if (this.weight == b.weight) {
                        if (this.index < b.index) {
                            return -1;
                        }
                    }
                }
            }
            return 1;
        }
    }
}
