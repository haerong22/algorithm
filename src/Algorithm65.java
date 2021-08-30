import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://programmers.co.kr/
 * 영어 끝말잇기
 *
 * 끝말잇기를 계속 진행해 나가다 보면, 3번 사람이 자신의 세 번째 차례에 말한 tank 라는 단어는 이전에 등장했던 단어이므로 탈락하게 됩니다.
 * 사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때,
 * 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 return 하도록 solution 함수를 완성해주세요.
 */

public class Algorithm65 {

    public static void main(String[] args) {
        int n = 5;
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        System.out.println(Arrays.toString(solution(n, words)));
    }

    public static int[] solution(int n, String[] words) {
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add(words[0]);
        int cnt = 0;
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)) {
                cnt = i; break;
            } else if (wordList.contains(words[i])) {
                cnt = i; break;
            } else {
                wordList.add(words[i]);
            }
        }
        return cnt == 0 ? new int[]{0,0} : new int[]{cnt%n+1, cnt/n+1};
    }

}
