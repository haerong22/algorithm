/**
 * https://programmers.co.kr/
 * 상호 평가
 *
 * ...
 * 학생들의 점수가 담긴 정수형 2차원 배열 scores가 매개변수로 주어집니다.
 * 이때, 학생들의 학점을 구하여 하나의 문자열로 만들어서 return 하도록 solution 함수를 완성해주세요.
 */

public class Algorithm52 {

    public static void main(String[] args) {
        int[][] scores = {
                {100, 90, 98, 88, 65},
                {50, 45, 99, 85, 77},
                {47, 88, 95, 80, 67},
                {61, 57, 100, 80, 65},
                {24, 90, 94, 75, 65}
        };
        System.out.println(solution(scores));
    }

    public static String solution(int[][] scores) {
        return findGrade(scores);
    }

    private static String findGrade(int[][] scores) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < scores.length; i++) {
            int max = 0;
            int min = 100;
            int total = 0;
            int cnt = 0;
            int myScore = scores[i][i];
            for (int j = 0; j < scores.length; j++) {
                max = Math.max(scores[j][i], max);
                min = Math.min(scores[j][i], min);
                total += scores[j][i];
                if (scores[j][i] == myScore) cnt++;
            }
            String grade;
            if (cnt == 1 && (scores[i][i] == max || scores[i][i] == min)) {
                grade = getGrade(total - scores[i][i], scores.length - 1);
            } else {
                grade = getGrade(total, scores.length);
            }
            sb.append(grade);
        }
        return sb.toString();
    }

    private static String getGrade(int total, int length) {
        double avg = (double) total/length;
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }

}
