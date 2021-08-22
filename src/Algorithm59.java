/**
 * https://programmers.co.kr/
 * 땅따먹기
 *
 * ...
 *
 * 마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요.
 * 위 예의 경우, 1행의 네번째 칸 (5), 2행의 세번째 칸 (7), 3행의 첫번째 칸 (4) 땅을 밟아 16점이 최고점이 되므로 16을 return 하면 됩니다.
 */

public class Algorithm59 {

    public static void main(String[] args) {
        int[][] land = {
                {1,2,3,5},
                {5,6,7,8},
                {4,3,2,1}
        };

        System.out.println(solution(land));
    }

    static int solution(int[][] land) {
        int answer = 0;
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        max = Math.max(land[i-1][k], max);
                    }
                }
                land[i][j] += max;
            }
        }
        for (int i = 0; i < 4; i++) {
            answer = Math.max(land[land.length-1][i], answer);
        }
        return answer;
    }
}
