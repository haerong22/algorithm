/**
 * https://programmers.co.kr/
 * 직업군 추천하기
 *
 * 직업군 언어 점수를 정리한 문자열 배열 table,
 * 개발자가 사용하는 언어를 담은 문자열 배열 languages,
 * 언어 선호도를 담은 정수 배열 preference가 매개변수로 주어집니다.
 * 개발자가 사용하는 언어의 언어 선호도 x 직업군 언어 점수의 총합이 가장 높은 직업군을 return 하도록 solution 함수를 완성해주세요.
 * 총합이 같은 직업군이 여러 개일 경우, 이름이 사전 순으로 가장 빠른 직업군을 return 해주세요.
 */

public class Algorithm62 {

    public static void main(String[] args) {
        String[] table = {
                "SI JAVA JAVASCRIPT SQL PYTHON C#",
                "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
                "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA"
        };
        String[] languages = {"PYTHON", "C++", "SQL"};

        int[] preference = {7, 5, 5};
        System.out.println(solution(table, languages, preference));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int max = 0;
        for (String job : table) {
            int sum = 0;
            String[] list = job.split(" ");
            for (int i = 1; i < list.length; i++) {
                for (int j = 0; j < languages.length; j++) {
                    if (list[i].equals(languages[j])) {
                        sum += preference[j] * (list.length - i);
                    }
                }
            }
            if (sum > max) {
                max = sum;
                answer = list[0];
            } else if (sum == max) {
                answer = answer.compareTo(list[0]) < 0 ? answer : list[0];
            }
        }
        return answer;
    }
}
